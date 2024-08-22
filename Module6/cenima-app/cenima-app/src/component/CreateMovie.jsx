import React, { useState } from 'react';
import { storage } from "./firebaseConfig";
import './createMovie.css';
import { ErrorMessage, Field, Form, Formik } from "formik";
import Service from "../service/service";

const CreateMovie = () => {
    const [images, setImages] = useState([]);

    const handleImageChange = (event) => {
        const files = Array.from(event.target.files);
        const imageUrls = files.map(file => URL.createObjectURL(file));
        setImages(prevImages => [...prevImages, ...imageUrls]);
    };

    return (
        <div className="container mx-auto p-4">
            <div className="animate__animated animate__bounceInDown">
                <h1 className="text-3xl font-bold mb-6 text-black-300">Thêm mới phim</h1>
            </div>
            <Formik
                initialValues={{
                    actor: '',
                    avatar: '',
                    content: '',
                    director: '',
                    durationMovie: '',
                    nameMovie: '',
                    releaseDate: '',
                    studio: '',
                    trailer: '',
                    kindOfMovieId: '',
                    statusMovieId: '',
                    poster: ''
                }}
                onSubmit={async (values, { setSubmitting }) => {
                    try {
                        await Service.createMovie(values);
                    } catch (e) {
                        console.error("Lỗi thêm mới sản phẩm:", e);
                    } finally {
                        setSubmitting(false);
                    }
                }}
            >
                {({ isSubmitting }) => (
                    <Form className="space-y-6">
                        <div className="form-group animate__animated animate__bounceInRight">
                            <label htmlFor="avatar" className="block font-semibold mb-1">Hình ảnh<span className="text-red-500">(*)</span></label>
                            <Field
                                type="file"
                                id="avatar"
                                name="avatar"
                                accept="image/*"
                                className="block w-full p-2 border border-gray-700 rounded-md"
                                onChange={handleImageChange}
                                multiple
                            />
                            <div id="image-preview" className="mt-2 flex flex-wrap">
                                {images.map((src, index) => (
                                    <img
                                        key={index}
                                        src={src}
                                        alt={`preview-${index}`}
                                        className="w-32 h-32 object-cover m-2"
                                    />
                                ))}
                            </div>
                            <ErrorMessage
                                name="avatar"
                                component="div"
                                className="text-danger"
                            />
                        </div>
                        <div className="form-group animate__animated animate__bounceInRight">
                            <label htmlFor="nameMovie" className="block font-semibold mb-1">Tên phim <span className="text-red-500">(*)</span></label>
                            <Field type="text" id="nameMovie" name="nameMovie" required className="block w-full p-2 border border-gray-700 rounded-md" />
                            <ErrorMessage
                                name="nameMovie"
                                component="div"
                                className="text-danger"
                            />
                        </div>
                        <div className="form-group animate__animated animate__bounceInRight">
                            <label htmlFor="actor" className="block font-semibold mb-1">Diễn viên <span className="text-red-500">(*)</span></label>
                            <Field type="text" id="actor" name="actor" required className="block w-full p-2 border border-gray-700 rounded-md" />
                            <ErrorMessage
                                name="actor"
                                component="div"
                                className="text-danger"
                            />
                        </div>
                        <div className="form-group animate__animated animate__bounceInRight">
                            <label htmlFor="director" className="block font-semibold mb-1">Đạo diễn <span className="text-red-500">(*)</span></label>
                            <Field type="text" id="director" name="director" required className="block w-full p-2 border border-gray-700 rounded-md" />
                            <ErrorMessage
                                name="director"
                                component="div"
                                className="text-danger"
                            />
                        </div>
                        <div className="form-group animate__animated animate__bounceInRight">
                            <label htmlFor="releaseDate" className="block font-semibold mb-1">Ngày phát hành <span className="text-red-500">(*)</span></label>
                            <Field type="date" id="releaseDate" name="releaseDate" required className="block w-full p-2 border border-gray-700 rounded-md" />
                            <ErrorMessage
                                name="releaseDate"
                                component="div"
                                className="text-danger"
                            />
                        </div>
                        {/*<div className="form-group animate__animated animate__bounceInRight">*/}
                        {/*    <label htmlFor="studio" className="block font-semibold mb-1">Hãng phim <span className="text-red-500">(*)</span></label>*/}
                        {/*    <Field type="text" id="studio" name="studio" required className="block w-full p-2 border border-gray-700 rounded-md" />*/}
                        {/*    <ErrorMessage*/}
                        {/*        name="studio"*/}
                        {/*        component="div"*/}
                        {/*        className="text-danger"*/}
                        {/*    />*/}
                        {/*</div>*/}
                        <div className="form-group animate__animated animate__bounceInRight">
                            <label htmlFor="durationMovie" className="block font-semibold mb-1">Thời lượng (phút) <span className="text-red-500">(*)</span></label>
                            <Field type="number" id="durationMovie" name="durationMovie" required className="block w-full p-2 border border-gray-700 rounded-md" />
                            <ErrorMessage
                                name="durationMovie"
                                component="div"
                                className="text-danger"
                            />
                        </div>
                        <div className="form-group animate__animated animate__bounceInRight">
                            <label htmlFor="trailer" className="block font-semibold mb-1">Trailer <span className="text-red-500">(*)</span></label>
                            <Field type="text" id="trailer" name="trailer" className="block w-full p-2 border border-gray-700 rounded-md" />
                            <ErrorMessage
                                name="trailer"
                                component="div"
                                className="text-danger"
                            />
                        </div>
                        <div className="form-group animate__animated animate__bounceInRight">
                            <label htmlFor="screening-room" className="block font-semibold mb-1">Phòng chiếu <span className="text-red-500">(*)</span></label>
                            <Field as="select" id="studio" name="screeningRoom" className="block w-full p-2 border border-gray-700 rounded-md">
                                <option value="PC001">PC001</option>
                                {/* Thêm các tùy chọn khác nếu cần */}
                            </Field>
                        </div>
                        <div className="form-group animate__animated animate__bounceInRight">
                            <label htmlFor="content" className="block font-semibold mb-1">Nội dung</label>
                            <Field as="textarea" id="content" name="content" className="block w-full p-2 border border-gray-700 rounded-md" />
                        </div>
                        <div className="form-group animate__animated animate__bounceInRight">
                            <label className="block font-semibold mb-1">Thể loại <span className="text-red-500">(*)</span></label>
                            <div className="checkbox-group flex flex-wrap">
                                <div className="flex items-center mr-4">
                                    <Field type="checkbox" id="kindOfMovieId" name="kindOfMovieId" value="action" className="form-checkbox text-blue-600" />
                                    <label htmlFor="action" className="ml-2">Hành Động</label>
                                </div>
                                {/* Thêm các thể loại khác */}
                            </div>
                        </div>
                        <div className="form-group animate__animated animate__bounceInRight">
                            <label htmlFor="screening-time" className="block font-semibold mb-1">Lịch chiếu <span className="text-red-500">(*)</span></label>
                            <Field type="text" id="screening-time" name="screeningTime" className="block w-full p-2 border border-gray-700 rounded-md" />
                            <button type="button" className="mt-2 py-2 px-4 bg-blue-600 text-white rounded-md">Thêm giờ chiếu</button>
                        </div>
                        <div className="animate__animated animate__bounceInRight flex space-x-4">
                            <button type="submit" id="save" className="py-2 px-4 bg-green-600 text-white rounded-md">Lưu</button>
                            <button type="button" id="remove" className="py-2 px-4 bg-red-600 text-white rounded-md">Quay lại</button>
                        </div>
                    </Form>
                )}
            </Formik>
        </div>
    );
};

export default CreateMovie;
