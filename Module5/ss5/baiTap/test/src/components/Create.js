import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from "yup";
import React from "react";
import {ColorRing} from "react-loader-spinner";


export function Create() {
    return(
        <Formik initialValues={{
            ten : 'Lê Đăng Trình',
            ngaySinh: '2002-03-23',
            gioiTinh: '1',
            diaChi: 'Quảng Nam'
        }}
                onSubmit={(values,{setSubmitting}) => {
                    setTimeout( () =>{
                        setSubmitting = false;
                        console.log(values)
                    },2000)

                }}
                validationSchema={Yup.object({
                    ten : Yup.string()
                        .required('Vui lòng nhập giá trị')
                        .matches(/^[A-Za-z\s]{5,}/,'Tên không chứa kí tự số và lớn hơn 5 kí tự' ),
                    ngaySinh: Yup.string()
                        .required('Vui lòng nhập ngày sinh'),
                    gioiTinh: Yup.number()
                        .required("vui lòng chọn giới tính"),
                    diaChi : Yup.string()
                        .required('Vui lòng nhập địa chỉ')
                        .matches(/[A-Za-z1-9\s]{7,}/,'Địa chỉ phải lớn hơn 7 kí tự ')
                })}
        >
            {
                ({isSubmitting}) => (
                    <div className="App">
                        <div className="row justify-content-around">
                            <form id="create" className="col-md-5 bg-light p-3 my-3">
                                <h1 className="text-center text-uppercase py-3">Create Student</h1>
                                <div className="form-group">
                                    <label htmlFor="ten" className="form-label my-2">Tên: </label>
                                    <Field type={"text"} id="ten" className="form-control" name='ten'/>
                                    <ErrorMessage name='ten' component='span'/>
                                </div>
                                <div className="form-group">
                                    <label htmlFor="ngaySinh" className="my-2 form-label text-start">Ngày sinh: </label>
                                    <Field type="date" id="ngaySinh" className="form-control" name='ngaySinh' />
                                    <ErrorMessage name='ngaySinh' component='span'/>
                                </div>
                                <div className="form-check-inline">
                                    <label htmlFor="gioiTinh" className="form-label my-2">Giới tính:</label>
                                    <div className="form-check-inline ml-2">
                                        <Field
                                            type="radio"
                                            id="gioiTinhNam"
                                            name="gioiTinh"
                                            value="1"
                                            className="form-check-input"
                                        />
                                        <label htmlFor="gioiTinhNam" className="form-check-label">Nam</label>
                                    </div>
                                    <div className="form-check-inline">
                                        <input
                                            type="radio"
                                            id="gioiTinhNu"
                                            name="gioiTinh"
                                            value="2"
                                            className="form-check-input"
                                        />
                                        <label htmlFor="gioiTinhNu" className="form-check-label">Nữ</label>
                                    </div>
                                    <div className="form-check-inline">
                                        <input
                                            type="radio"
                                            id="gioiTinhKhac"
                                            name="gioiTinh"
                                            value="3"
                                            className="form-check-input"
                                        />
                                        <label htmlFor="gioiTinhKhac" className="form-check-label">Khác</label>
                                    </div>
                                    <ErrorMessage name='gioiTinh' component='span' />
                                </div>
                                <div className="form-label">
                                    <label htmlFor="diaChi" className="form-label my-2">Địa chỉ:</label>
                                    <Field type={"text"} id="diaChi" className="form-control" name='diaChi'/>
                                    <ErrorMessage name='diaChi' component='span' />
                                </div>
                                <div className="text-center my-4">
                                    {
                                        isSubmitting ?
                                            <ColorRing
                                                visible={true}
                                                height="80"
                                                width="80"
                                                ariaLabel="color-ring-loading"
                                                wrapperStyle={{}}
                                                wrapperClass="color-ring-wrapper"
                                                colors={['#e15b64', '#f47e60', '#f8b26a', '#abbd81', '#849b87']}
                                            />
                                             :
                                            <input type={"submit"} id="submit" className="btn btn-outline-primary mr-5" value="thêm mới"/>
                                    }
                                            <a href={"/"}role={"button"} className={"btn btn-outline-danger"} >Trở lại</a>

                                </div>
                            </form>
                        </div>

                    </div>
                )


            }
        </Formik>
)
}

