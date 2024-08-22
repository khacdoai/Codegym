import React, { useState } from 'react';
import { storage } from './firebaseConfig';
import { ref, uploadBytes, getDownloadURL } from 'firebase/storage';
import './CreateEmployee.css';
import Swal from 'sweetalert2';
import withReactContent from 'sweetalert2-react-content';
const CreateEmployee = () => {
    const [formData, setFormData] = useState({
        hinh_anh: '',
        mat_khau: '',
        nhap_lai_mat_khau: '',
        ho_ten: '',
        ngay: '',
        thang: '',
        nam: '',
        gioi_tinh: 'nam',
        email: '',
        cmnd: '',
        so_dien_thoai: '',
        dia_chi: ''
    });
    const [errorMessage, setErrorMessage] = useState('');
    const [imagePreview, setImagePreview] = useState('');
    const [progress, setProgress] = useState(0);
    const [downloadURL, setDownloadURL] = useState('');
    const [showPassword, setShowPassword] = useState(false);
    const [showConfirmPassword, setShowConfirmPassword] = useState(false);
    const [errors, setErrors] = useState({});
    const [successMessage, setSuccessMessage] = useState('');
    const MySwal = withReactContent(Swal);
    const handleFileChange = (e) => {
        const file = e.target.files[0];
        setFormData({ ...formData, hinh_anh: file });

        const reader = new FileReader();
        reader.onload = () => {
            setImagePreview(reader.result);
        };
        reader.readAsDataURL(file);
    };

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };
    const handleBlur = () => {
        validate();
    };
    const validate = () => {
        const isLeapYear = (year) => {
            return (year % 4 === 0 && year % 100 !== 0) || (year % 400 === 0);
        };
        const errors = {};
        const { mat_khau, nhap_lai_mat_khau, ho_ten, ngay, thang, nam, email, cmnd, so_dien_thoai, dia_chi, hinh_anh } = formData;

        if (!nhap_lai_mat_khau) {
            errors.nhap_lai_mat_khau = 'Nhập lại mật khẩu là bắt buộc.';
        }
        if (!mat_khau) {
            errors.mat_khau = 'Mật khẩu là bắt buộc.';
        } else if (mat_khau.length < 8 || !/[A-Za-z]/.test(mat_khau) || !/\d/.test(mat_khau) || !/[!@#$%^&*()_+{}\[\]:;"'<>,.?/]/.test(mat_khau)) {
            errors.mat_khau = 'Mật khẩu phải có ít nhất 8 ký tự, bao gồm cả chữ cái, số và ký tự đặc biệt.';
        } else if (mat_khau !== nhap_lai_mat_khau) {
            errors.mat_khau = 'Mật khẩu và nhập lại mật khẩu phải giống nhau.';
        } else if (nhap_lai_mat_khau.length < 8 || !/[A-Za-z]/.test(mat_khau) || !/\d/.test(mat_khau) || !/[!@#$%^&*()_+{}\[\]:;"'<>,.?/]/.test(mat_khau)) {
            errors.mat_khau = 'Nhập lại mật khẩu phải có ít nhất 8 ký tự, bao gồm cả chữ cái, số và ký tự đặc biệt.';
        }
        if (!hinh_anh) {
            errors.hinh_anh = 'Hình ảnh là bắt buộc ';
        }
        if (!ho_ten) {
            errors.ho_ten = 'Họ tên là bắt buộc ';
        } else if (/\d/.test(ho_ten)) {
            errors.ho_ten = 'Họ tên không hợp lệ. Không được chứa số.';
        }

        const today = new Date();
        const birthDate = new Date(nam, thang - 1, ngay);
        if (!ngay || !thang || !nam) {
            errors.ngay_sinh = 'Ngày sinh là bắt buộc.';
        } else if (birthDate >= today) {
            errors.ngay_sinh = 'Ngày sinh không hợp lệ. Ngày sinh phải nhỏ hơn ngày hiện tại.';
        } else if (thang == 2 && !isLeapYear(nam) && ngay > 28) {
            errors.ngay = 'Tháng 2 không phải năm nhuận chỉ có tối đa 28 ngày.';
        } else if (thang == 2 && isLeapYear(nam) && ngay > 29) {
            errors.ngay = 'Tháng 2 năm nhuận chỉ có tối đa 29 ngày.';
        } else if ([4, 6, 9, 11].includes(parseInt(thang)) && ngay > 30) {
            errors.ngay = 'Tháng này chỉ có tối đa 30 ngày.';
        } else if (![1, 3, 5, 7, 8, 10, 12].includes(parseInt(thang)) && ngay > 31) {
            errors.ngay = 'Tháng này chỉ có tối đa 31 ngày.';
        }

        if (!email) {
            errors.email = 'Email là bắt buộc';
        } else if (!/\S+@\S+\.\S+/.test(email)) {
            errors.email = 'Email không hợp lệ.';
        }
        if (!cmnd) {
            errors.cmnd = 'CMND/CCCD là bắt buộc';
        } else if (!/^\d{9,12}$/.test(cmnd)) {
            errors.cmnd = 'CMND/CCCD không hợp lệ.';
        }
        if (!so_dien_thoai) {
            errors.so_dien_thoai = 'Số điện thoại là bắt buộc.';
        } else if (!/^\d{10,11}$/.test(so_dien_thoai)) {
            errors.so_dien_thoai = 'Số điện thoại không hợp lệ.';
        }
        if (!dia_chi) {
            errors.dia_chi = 'Địa chỉ là bắt buộc.';
        }

        setErrors(errors);
        return Object.keys(errors).length === 0;
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        MySwal.fire({
            title: 'Xác nhận',
            text: 'Bạn có chắc chắn muốn thêm nhân viên này?',
            icon: 'question',
            showCancelButton: true,
            confirmButtonColor: 'bg-gradient-to-r from-blue-500 to-purple-500',
            cancelButtonColor: 'bg-gradient-to-r from-gray-500 to-gray-700',
            confirmButtonText: 'Có',
            cancelButtonText: 'Không'
        }).then(async (result) => {
            if (result.isConfirmed) {
                if (!validate()) {
                    setErrorMessage('Vui lòng kiểm tra các lỗi và thử lại.');
                    return;
                }

                if (formData.hinh_anh) {
                    const file = formData.hinh_anh;
                    const storageRef = ref(storage, `images/${file.name}`);
                    try {
                        const uploadTask = uploadBytes(storageRef, file);

                        uploadTask.on(
                            'state_changed',
                            (snapshot) => {
                                const progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
                                setProgress(progress);
                            },
                            (error) => {
                                console.error('Upload Error:', error);
                                setErrorMessage('Có lỗi xảy ra khi tải lên hình ảnh.');
                            },
                            () => {
                                getDownloadURL(uploadTask.snapshot.ref).then((url) => {
                                    setDownloadURL(url);
                                    setFormData({ ...formData, hinh_anh: url });
                                    setSuccessMessage('Upload thành công!');
                                    setErrorMessage('');
                                });
                            }
                        );
                    } catch (error) {
                        console.error('Error uploading file:', error);
                        setErrorMessage('Có lỗi xảy ra khi tải lên hình ảnh.');
                    }
                }

                localStorage.setItem('employeeData', JSON.stringify(formData));
                setSuccessMessage('Dữ liệu đã được thêm thành công!');
                setErrorMessage('');

                setFormData({
                    hinh_anh: '',
                    mat_khau: '',
                    nhap_lai_mat_khau: '',
                    ho_ten: '',
                    ngay: '',
                    thang: '',
                    nam: '',
                    gioi_tinh: 'nam',
                    email: '',
                    cmnd: '',
                    so_dien_thoai: '',
                    dia_chi: ''
                });
                setImagePreview('');
                setProgress(0);
                setDownloadURL('');
            }
        });
    };
return (
    <div
        className="bg-gradient-to-r from-blue-100 via-purple-100 to-pink-100 min-h-screen flex items-center justify-center">
        <div className="container mx-auto p-8 min-h-screen">
            <div className="max-w-3xl w-full mx-auto bg-white p-8 rounded-lg shadow-lg">
                <h2 className="text-3xl font-bold mb-6 text-center text-purple-700">THÊM MỚI NHÂN VIÊN</h2>
                {successMessage && (
                    <div className="mb-4 bg-green-100 border border-green-400 text-green-700 px-4 py-3 rounded relative" role="alert">
                        <span className="block sm:inline">{successMessage}</span>
                        <span className="absolute top-0 bottom-0 right-0 px-4 py-3" onClick={() => setSuccessMessage('')}>
                                <svg className="fill-current h-6 w-6 text-green-500" role="button" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
                                    <title>Close</title>
                                    <path d="M14.348 5.652a.5.5 0 00-.707 0L10 9.293 6.36 5.652a.5.5 0 00-.707.707L9.293 10l-3.64 3.641a.5.5 0 00.707.707L10 10.707l3.641 3.64a.5.5 0 00.707-.707L10.707 10l3.64-3.641a.5.5 0 000-.707z" />
                                </svg>
                            </span>
                    </div>
                )}
                <form onSubmit={handleSubmit} id="employeeForm" encType="multipart/form-data">
                    <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                    <div className="mb-4 ">
                        <label className="block text-gray-700 font-bold text-sm">Hình ảnh <span
                            className="text-red-500">*</span></label>
                        <input type="file" name="hinh_anh" className="block w-full mt-2 form-input text-sm "
                               onChange={handleFileChange}onBlur={handleBlur}/>
                        {imagePreview && <img src={imagePreview} alt="Preview" className="preview-image"/>}
                        {errors.hinh_anh && <p className="text-red-500 text-sm">{errors.hinh_anh}</p>}
                    </div>
                        <div className="mb-4">
                            <label className="block text-gray-700 font-bold text-sm">Họ tên <span
                                className="text-red-500">*</span></label>
                            <input type="text" name="ho_ten" className="block w-full mt-2 form-input text-sm"
                                   value={formData.ho_ten} onChange={handleChange} onBlur={handleBlur}/>
                            {errors.ho_ten && <p className="text-red-500 text-sm">{errors.ho_ten}</p>}
                        </div>
                    </div>
                    <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                    <div className="mb-4 ">
                        <label className="block text-gray-700 font-bold text-sm">Mật khẩu <span
                            className="text-red-500">*</span></label>
                        <div className="relative">
                            <input
                                type={showPassword ? 'text' : 'password'}
                                name="mat_khau"
                                className="block w-full mt-2 form-input text-sm"
                                value={formData.mat_khau}
                                onChange={handleChange}
                                onBlur={handleBlur}
                            />
                            <div className="absolute inset-y-0 right-0 pr-3 flex items-center text-sm">
                                <svg
                                    className={`h-6 text-gray-700 cursor-pointer ${showPassword ? 'hidden' : 'block'}`}
                                    fill="none"
                                    onClick={() => setShowPassword(!showPassword)}
                                    xmlns="http://www.w3.org/2000/svg"
                                    viewBox="0 0 576 512"
                                >
                                    <path
                                        fill="currentColor"
                                        d="M572.52 241.4C518.29 135.59 410.93 64 288 64S57.68 135.64 3.48 241.41a32.35 32.35 0 0 0 0 29.19C57.71 376.41 165.07 448 288 448s230.32-71.64 284.52-177.41a32.35 32.35 0 0 0 0-29.19zM288 400a144 144 0 1 1 144-144 143.93 143.93 0 0 1-144 144zm0-240a95.31 95.31 0 0 0-25.31 3.79 47.85 47.85 0 0 1-66.9 66.9A95.78 95.78 0 1 0 288 160z"
                                    />
                                </svg>
                                <svg
                                    className={`h-6 text-gray-700 cursor-pointer ${showPassword ? 'block' : 'hidden'}`}
                                    fill="none"
                                    onClick={() => setShowPassword(!showPassword)}
                                    xmlns="http://www.w3.org/2000/svg"
                                    viewBox="0 0 640 512"
                                >
                                    <path
                                        fill="currentColor"
                                        d="M320 400c-75.85 0-137.25-58.71-142.9-133.11L72.2 185.82c-13.79 17.3-26.48 35.59-36.72 55.59a32.35 32.35 0 0 0 0 29.19C89.71 376.41 197.07 448 320 448c26.91 0 52.87-4 77.89-10.46L346 397.39a144.13 144.13 0 0 1-26 2.61zm313.82 58.1l-110.55-85.44a331.25 331.25 0 0 0 81.25-102.07 32.35 32.35 0 0 0 0-29.19C550.29 135.59 442.93 64 320 64a308.15 308.15 0 0 0-147.32 37.7L45.46 3.37A16 16 0 0 0 23 6.18L3.37 31.45A16 16 0 0 0 6.18 53.9l588.36 454.73a16 16 0 0 0 22.46-2.81l19.64-25.27a16 16 0 0 0-2.82-22.45zm-183.72-142l-39.3-30.38A94.75 94.75 0 0 0 416 256a94.76 94.76 0 0 0-121.31-92.21A47.65 47.65 0 0 1 304 192a46.64 46.64 0 0 1-1.54 10l-73.61-56.89A142.31 142.31 0 0 1 320 112a143.92 143.92 0 0 1 144 144c0 21.63-5.29 41.79-13.9 60.11z"
                                    />
                                </svg>
                            </div>
                        </div>
                        {errors.mat_khau && <p className="text-red-500 text-sm">{errors.mat_khau}</p>}
                    </div>
                    <div className="mb-4">
                        <label className="block text-gray-700 font-bold text-sm">Nhập lại mật khẩu <span
                            className="text-red-500">*</span></label>
                        <div className="relative">
                            <input
                                type={showConfirmPassword ? 'text' : 'password'}
                                name="nhap_lai_mat_khau"
                                className="block w-full mt-2 form-input text-sm"
                                value={formData.nhap_lai_mat_khau}
                                onChange={handleChange}
                                onBlur={handleBlur}
                            />
                            <div className="absolute inset-y-0 right-0 pr-3 flex items-center text-sm">
                                <svg
                                    className={`h-6 text-gray-700 cursor-pointer ${showConfirmPassword ? 'hidden' : 'block'}`}
                                    fill="none"
                                    onClick={() => setShowConfirmPassword(!showConfirmPassword)}
                                    xmlns="http://www.w3.org/2000/svg"
                                    viewBox="0 0 576 512"
                                >
                                    <path
                                        fill="currentColor"
                                        d="M572.52 241.4C518.29 135.59 410.93 64 288 64S57.68 135.64 3.48 241.41a32.35 32.35 0 0 0 0 29.19C57.71 376.41 165.07 448 288 448s230.32-71.64 284.52-177.41a32.35 32.35 0 0 0 0-29.19zM288 400a144 144 0 1 1 144-144 143.93 143.93 0 0 1-144 144zm0-240a95.31 95.31 0 0 0-25.31 3.79 47.85 47.85 0 0 1-66.9 66.9A95.78 95.78 0 1 0 288 160z"
                                    />
                                </svg>
                                <svg
                                    className={`h-6 text-gray-700 cursor-pointer ${showConfirmPassword ? 'block' : 'hidden'}`}
                                    fill="none"
                                    onClick={() => setShowConfirmPassword(!showConfirmPassword)}
                                    xmlns="http://www.w3.org/2000/svg"
                                    viewBox="0 0 640 512"
                                >
                                    <path
                                        fill="currentColor"
                                        d="M320 400c-75.85 0-137.25-58.71-142.9-133.11L72.2 185.82c-13.79 17.3-26.48 35.59-36.72 55.59a32.35 32.35 0 0 0 0 29.19C89.71 376.41 197.07 448 320 448c26.91 0 52.87-4 77.89-10.46L346 397.39a144.13 144.13 0 0 1-26 2.61zm313.82 58.1l-110.55-85.44a331.25 331.25 0 0 0 81.25-102.07 32.35 32.35 0 0 0 0-29.19C550.29 135.59 442.93 64 320 64a308.15 308.15 0 0 0-147.32 37.7L45.46 3.37A16 16 0 0 0 23 6.18L3.37 31.45A16 16 0 0 0 6.18 53.9l588.36 454.73a16 16 0 0 0 22.46-2.81l19.64-25.27a16 16 0 0 0-2.82-22.45zm-183.72-142l-39.3-30.38A94.75 94.75 0 0 0 416 256a94.76 94.76 0 0 0-121.31-92.21A47.65 47.65 0 0 1 304 192a46.64 46.64 0 0 1-1.54 10l-73.61-56.89A142.31 142.31 0 0 1 320 112a143.92 143.92 0 0 1 144 144c0 21.63-5.29 41.79-13.9 60.11z"
                                    />
                                </svg>
                            </div>
                        </div>
                        {errors.nhap_lai_mat_khau && <p className="text-red-500 text-sm">{errors.nhap_lai_mat_khau}</p>}
                    </div>
                    </div>
                    <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                        <div className="mb-4">
                            <label className="block text-gray-700 font-bold text-sm">Ngày sinh <span className="text-red-500">*</span></label>
                            <div className="flex space-x-2">
                                <select id="ngay" name="ngay" className="w-1/3 form-input text-sm" value={formData.ngay}
                                        onChange={handleChange} onBlur={handleBlur}>
                                    <option value="" disabled>Ngày</option>
                                    {[...Array(31)].map((_, i) => (
                                        <option key={i} value={i + 1}>{i + 1}</option>
                                    ))}
                                </select>
                                <select id="thang" name="thang" className="w-1/3 form-input text-sm" value={formData.thang}
                                        onChange={handleChange} onBlur={handleBlur}>
                                    <option value="" disabled>Tháng</option>
                                    {[...Array(12)].map((_, i) => (
                                        <option key={i} value={i + 1}>{i + 1}</option>
                                    ))}
                                </select>
                                <select id="nam" name="nam" className="w-1/3 form-input text-sm" value={formData.nam}
                                        onChange={handleChange} onBlur={handleBlur}>
                                    <option value="" disabled>Năm</option>
                                    {[...Array(new Date().getFullYear() - 1899)].map((_, i) => (
                                        <option key={i} value={1900 + i}>{1900 + i}</option>
                                    ))}
                                </select>
                            </div>
                            {errors.ngay_sinh && <p className="text-red-500 text-sm">{errors.ngay_sinh}</p>}
                            {errors.ngay && <p className="text-red-500 text-sm">{errors.ngay}</p>}
                        </div>
                        <div className="mb-4">
                            <label className="block text-gray-700 font-bold text-sm">Giới tính <span
                                className="text-red-500">*</span></label>
                            <div className="mt-2 text-left">
                                <label className="inline-flex items-center ">
                                    <input type="radio" name="gioi_tinh" value="nam" className="form-radio"
                                           checked={formData.gioi_tinh === 'nam'} onChange={handleChange}/>
                                    <span className="ml-2">Nam</span>
                                </label>
                                <label className="inline-flex items-center ml-6">
                                    <input type="radio" name="gioi_tinh" value="nu" className="form-radio"
                                           checked={formData.gioi_tinh === 'nu'} onChange={handleChange}/>
                                    <span className="ml-2">Nữ</span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                        <div className="mb-4">
                            <label className="block text-gray-700 font-bold text-sm">Email <span
                                className="text-red-500">*</span></label>
                            <input type="email" name="email" className="block w-full mt-2 form-input text-sm"
                                   value={formData.email} onChange={handleChange} onBlur={handleBlur}/>
                            {errors.email && <p className="text-red-500 text-sm">{errors.email}</p>}
                        </div>
                        <div className="mb-4">
                            <label className="block text-gray-700 font-bold text-sm">Địa chỉ <span
                                className="text-red-500">*</span></label>
                            <input type="text" name="dia_chi" className="block w-full mt-2 form-input text-sm"
                                   value={formData.dia_chi} onChange={handleChange} onBlur={handleBlur}/>
                            {errors.dia_chi && <p className="text-red-500 text-sm">{errors.dia_chi}</p>}
                        </div>

                    </div>


                    <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                    <div className="mb-4">
                        <label className="block text-gray-700 font-bold text-sm">CMND/CCCD <span
                            className="text-red-500">*</span></label>
                        <input type="text" name="cmnd" className="block w-full mt-2 form-input text-sm"
                               value={formData.cmnd} onChange={handleChange} onBlur={handleBlur}/>
                        {errors.cmnd && <p className="text-red-500 text-sm">{errors.cmnd}</p>}
                    </div>
                    <div className="mb-4">
                        <label className="block text-gray-700 font-bold text-sm">Số điện thoại <span
                            className="text-red-500">*</span></label>
                        <input type="text" name="so_dien_thoai" className="block w-full mt-2 form-input text-sm"
                               value={formData.so_dien_thoai} onChange={handleChange} onBlur={handleBlur}/>
                        {errors.so_dien_thoai && <p className="text-red-500 text-sm">{errors.so_dien_thoai}</p>}
                    </div>
                    </div>

                    <div className="flex justify-between">
                        <button type="submit"
                                className="bg-gradient-to-r from-blue-500 to-purple-500 text-white py-2 px-4 rounded whitespace-nowrap">Thêm mới
                        </button>
                        <button type="button" onClick="history.back()"
                                className="bg-gradient-to-r from-gray-500 to-gray-700 text-white py-2 px-4 rounded whitespace-nowrap">Quay lại
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
);
}

export default CreateEmployee;
