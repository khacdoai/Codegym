
import React from "react";
import {Field, Form, Formik} from "formik";

export function Create() {
    return(
        <Formik initialValues={{
            tenSanPham : 'Iphone 11 promax',
            ngayNhap: '2024-03-15',
            gia: 12.0000000,
            chiTietSanPham: 'Không',
            nhaCungCap: 'apple'
        }}
                onSubmit={(values) => {
                    console.log(values);
                }}>
            <div className="App">
                <div className="row justify-content-around">
                    <Form id="create" className="col-md-5 bg-light p-3 my-3">
                        <h1 className="text-center text-uppercase py-3">Create Product</h1>
                        <div className="form-group">
                            <label htmlFor="tenSanPham" className="form-label my-2">Tên sản phẩm: </label>
                            <Field type="text" name="tenSanPham" className="form-control"  />
                        </div>
                        <div className="form-group">
                            <label htmlFor="ngayNhap" className="my-2 form-label text-start">Ngày Nhập: </label>
                            <Field type="date" name="ngayNhap" className="form-control" />
                            <div className="form-group">
                                <label htmlFor="tenSanPham" className="form-label my-2">Giá : </label>
                                <Field type="text" name="gia" className="form-control" />
                            </div>

                            <div className="form-group">
                                <label htmlFor="tenSanPham" className="form-label my-2">Chi tiết sản phẩm : </label>
                                <Field type="text" name="chiTietSanPham" className="form-control" />
                            </div>
                            <div className="form-group">
                                <label htmlFor="tenSanPham" className="form-label my-2">Nhà cung cấp: </label>
                                <Field type="text" name="nhaCungCap" className="form-control" />
                            </div>
                            <div className="text-center my-4">
                                <input type="submit" id="submit" className="btn btn-outline-primary mr-5" value="thêm mới"  />
                                <a href="/" role="button" className="btn btn-outline-danger">Trở lại</a>
                            </div>
                        </div>
                    </Form>
                </div>
            </div>
        </Formik>
    );

}