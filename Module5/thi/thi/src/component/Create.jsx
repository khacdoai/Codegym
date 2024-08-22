import React from "react";
import { Field, Form, Formik, ErrorMessage } from "formik";
import * as Yup from "yup";
import { toast } from "react-toastify";
import { Link, useNavigate } from "react-router-dom";
import { ColorRing } from "react-loader-spinner";
import "react-toastify/dist/ReactToastify.css";
import axios from "axios";

function Create() {
    const navigate = useNavigate();

    return (
        <div className="container">
            <div className="row justify-content-center">
                <div className="col-lg-6">
                    <div className="text-center mb-4">
                        <h2>Thêm phòng mới</h2>
                    </div>
                    <Formik
                        initialValues={{
                            tenBaiHat: "",
                            caSi: "",
                            nhacSi: "",
                            thoiGianPhat: "",
                            soLuotThich: "",
                            trangThai: "",

                        }}
                        validationSchema={Yup.object({
                            tenBaiHat: Yup.string().required("Tên phòng là bắt buộc"),
                            caSi: Yup.string()
                                .matches(/^\d+$/, "Số điện thoại không hợp lệ")
                                .required("Số điện thoại là bắt buộc"),
                            nhacSi: Yup.date().required("Ngày là bắt buộc"),
                            thoiGianPhat: Yup.string().required(
                                "Phương thức thanh toán là bắt buộc"
                            ),
                            trangThai: Yup.string(),
                        })}
                        onSubmit={async (values, { setSubmitting }) => {
                            try {
                                await axios.post("http://localhost:8080/motelRoom", values);
                                toast.success(`Sản phẩm ${values.name} thêm mới thành công.`);
                                navigate("/");
                            } catch (error) {
                                console.error("Error creating product:", error);
                                toast.error("Có lỗi xảy ra khi thêm sản phẩm.");
                            } finally {
                                setSubmitting(false);
                            }
                        }}
                    >
                        {({ isSubmitting }) => (
                            <Form>
                                <div className="mb-3">
                                    <label className="form-label">Tên bài hát</label>
                                    <Field type="text" className="form-control" name="tenBaiHat" />
                                    <ErrorMessage
                                        name="name"
                                        component="div"
                                        className="text-danger"
                                    />
                                </div>
                                <div className="mb-3">
                                    <label className="form-label">Ca sĩ</label>
                                    <Field
                                        type="tel"
                                        className="form-control"
                                        name="caSi"
                                    />
                                    <ErrorMessage
                                        name="caSi"
                                        component="div"
                                        className="text-danger"
                                    />
                                </div>
                                <div className="mb-3">
                                    <label className="form-label">Nhạc sĩ</label>
                                    <Field type="date" className="form-control" name="nhacSi" />
                                    <ErrorMessage
                                        name="nhacSi"
                                        component="div"
                                        className="text-danger"
                                    />
                                </div>
                                <div className="mb-3">
                                    <label className="form-label">Thời gian phát</label>
                                    <Field type="date" className="form-control" name="thoiGianPhat" />
                                    <ErrorMessage
                                        name="thoiGianPhat"
                                        component="div"
                                        className="text-danger"
                                    />
                                </div>
                                <div className="mb-3">
                                    <label className="form-label">Số lượt thích</label>
                                    <Field type="date" className="form-control" name="soLuotThich" />
                                    <ErrorMessage
                                        name="soLuotThich"
                                        component="div"
                                        className="text-danger"
                                    />
                                </div>
                                <div className="mb-3">
                                    <label className="form-label">Trạng thái</label>
                                    <Field type="date" className="form-control" name="trangThai" />
                                    <ErrorMessage
                                        name="trangThai"
                                        component="div"
                                        className="text-danger"
                                    />
                                </div>
                                {/*<div className="mb-3">*/}
                                {/*    <label className="form-label">Phương thức thanh toán</label>*/}
                                {/*    <Field as="select" className="form-select" name="thoiGianPhat">*/}
                                {/*        <option value="">Chọn phương thức</option>*/}
                                {/*        <option value="zaloPay">Zalo Pay</option>*/}
                                {/*        <option value="viettelMonney">Viettel Monney</option>*/}
                                {/*        <option value="momo">Momo</option>*/}
                                {/*    </Field>*/}
                                {/*    <ErrorMessage*/}
                                {/*        name="payment"*/}
                                {/*        component="div"*/}
                                {/*        className="text-danger"*/}
                                {/*    />*/}
                                {/*</div>*/}
                                {isSubmitting ? (
                                    <ColorRing
                                        visible={true}
                                        height={80}
                                        width={80}
                                        ariaLabel="color-ring-loading"
                                        wrapperClassName="text-center"
                                        colors={[
                                            "#007bff",
                                            "#007bff",
                                            "#007bff",
                                            "#007bff",
                                            "#007bff",
                                        ]}
                                    />
                                ) : (
                                    <button
                                        type="submit"
                                        className="btn btn-primary me-2"
                                        disabled={isSubmitting}
                                    >
                                        {isSubmitting ? "Đang Thêm..." : "Thêm Sản Phẩm"}
                                    </button>
                                )}
                                <Link to="/" className="btn btn-secondary">
                                    Quay lại
                                </Link>
                            </Form>
                        )}
                    </Formik>
                </div>
            </div>
        </div>
    );
}

export default Create;