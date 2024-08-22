import React, { useState, useEffect } from "react";
import axios from "axios";
import "bootstrap/dist/css/bootstrap.min.css";
import "../style/List.css";

import { Button, Modal, Pagination } from "react-bootstrap";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
    faPlus,
    faTrash,
    faSearch,
    faEye,
    faAnglesLeft,
    faAnglesRight,
} from "@fortawesome/free-solid-svg-icons";

import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

import { Link } from "react-router-dom";
function List() {
    //Đây là chức năng list sản phẩm
    const [baiHat, setBaiHat] = useState([]);
    //Xóa sản phẩm
    const [showDeleteModal, setShowDeleteModal] = useState(false);
    const [roomToDelete, setRoomToDelete] = useState(null);
    //Phân trang
    const [currentPage, setCurrentPage] = useState(1);
    const [motelRoomPerPage] = useState(5);
    const [totalPages, setTotalPages] = useState(0);
    // tìm kiếm
    const [searchTerm, setSearchTerm] = useState("");
    //Xem chi tiết
    const [roomToView, setRoomToView] = useState(null);
    const [showDetailsModal, setShowDetailsModal] = useState(false);
    //Hàm thêm
    useEffect(() => {
        const fetchMotelroom = async () => {
            try {
                const response = await axios.get("http://localhost:3000/motelRoom");
                setBaiHat(response.data);
            } catch (error) {
                console.error("Lỗi khi tìm phòng trọ:", error);
            }
        };

        fetchMotelroom();
    }, []);

    // hàm xóa
    const handleShowDeleteModal = (product) => {
        setRoomToDelete(product);
        setShowDeleteModal(true);
    };

    const handleCloseDeleteModal = () => setShowDeleteModal(false);

    const handleDelete = async () => {
        try {
            await axios.delete(`http://localhost:3000/motelRoom/${roomToDelete.id}`);
            setBaiHat(baiHat.filter((room) => room.id !== roomToDelete.id));
            handleCloseDeleteModal();
            toast.success(`Xóa sản phẩm ${roomToDelete.name} thành công!`);
        } catch (error) {
            console.error("Error deleting product:", error);
            handleCloseDeleteModal();
        }
    };

    //Hàm tìm kiếm
    const filteredMotelRoom = baiHat.filter(
        (motelRoom) =>
            motelRoom.name &&
            motelRoom.name.toLowerCase().includes(searchTerm.toLowerCase())
    );

    const handleSearch = (event) => {
        setSearchTerm(event.target.value);
        setCurrentPage(1);
    };

    //Hàm phân trang
    useEffect(() => {
        if (baiHat.length > 0) {
            const totalPagesCount = Math.ceil(
                filteredMotelRoom.length / motelRoomPerPage
            );
            setTotalPages(totalPagesCount);
            if (currentPage > totalPagesCount) {
                setCurrentPage(totalPagesCount);
            }
        } else {
            setTotalPages(0);
            setCurrentPage(1);
        }
    }, [baiHat, motelRoomPerPage, currentPage]);

    const indexOfLastMotelRoom = currentPage * motelRoomPerPage;
    const indexOfFirstProduct = indexOfLastMotelRoom - motelRoomPerPage;

    const currentProducts = filteredMotelRoom.slice(
        indexOfFirstProduct,
        indexOfLastMotelRoom
    );

    const paginate = (pageNumber) => setCurrentPage(pageNumber);

    const handlePrevPage = () => {
        if (currentPage > 1) {
            setCurrentPage(currentPage - 1);
        }
    };

    const handleNextPage = () => {
        if (indexOfLastMotelRoom < filteredMotelRoom.length) {
            setCurrentPage(currentPage + 1);
        }
    };

    // Hàm xem chi tiết
    const handleShowDetailsModal = (motelRoom) => {
        setRoomToView(motelRoom);
        setShowDetailsModal(true);
    };
    const handleCloseDetailsModal = () => setShowDetailsModal(false);
    return (
        <div className="container">
            <div className="table-responsive">
                <div className="table-wrapper">
                    <div className="table-title">
                        <div className="row">
                            <div className="col-6">
                                <h2>
                                    Danh sách <b>Kho Nhạc</b>
                                </h2>
                            </div>
                            <div className="col-6">
                                <div className="search-box">
                                    <FontAwesomeIcon icon={faSearch} className="search-icon" />
                                    <input
                                        type="text"
                                        className="form-control"
                                        placeholder="Tìm kiếm&hellip;"
                                        value={searchTerm}
                                        onChange={handleSearch}
                                    />
                                </div>

                                <Link to="/create" className="btn btn-success add-product">
                                    <FontAwesomeIcon icon={faPlus} className="add-icons" /> Đăng kí bài hát
                                </Link>
                            </div>
                        </div>
                    </div>
                    <table className="table table-hover">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Tên bai hát</th>
                            <th>Ca sĩ</th>
                            <th>Nhạc sĩ</th>
                            <th>Thời gian phát</th>
                            <th>Số lượt thích</th>
                            <th>Trạng thái</th>
                        </tr>
                        </thead>
                        <tbody>
                        {currentProducts.map((room, index) => (
                            <tr key={index}>
                                <td>{index + 1}</td>
                                <td>{room.tenBaiHat}</td>
                                <td>{room.caSi}</td>
                                <td>{room.nhacSi}</td>
                                <td>{room.thoiGianPhat}</td>
                                <td>{room.soLuotThich}</td>
                                <td>{room.trangThai}</td>
                                <td>
                                    <FontAwesomeIcon
                                        icon={faEye}
                                        className="see-details-icons"
                                        onClick={() => handleShowDetailsModal(room)}
                                    />
                                    <FontAwesomeIcon
                                        icon={faTrash}
                                        className="delete-icons"
                                        onClick={() => handleShowDeleteModal(room)}
                                    />
                                </td>
                            </tr>
                        ))}
                        </tbody>
                    </table>

                    <div className="clearfix">
                        <div className="hint-text">
                            Hiển thị <b>{currentPage}</b> trong <b>{totalPages}</b> trang
                        </div>
                        <Pagination className="pagination">
                            <Pagination.Prev onClick={handlePrevPage}>
                                <FontAwesomeIcon icon={faAnglesLeft} />
                            </Pagination.Prev>
                            {Array.from(
                                {
                                    length: Math.ceil(
                                        filteredMotelRoom.length / motelRoomPerPage
                                    ),
                                },
                                (_, i) => (
                                    <Pagination.Item
                                        key={i}
                                        active={i + 1 === currentPage}
                                        onClick={() => paginate(i + 1)}
                                    >
                                        {i + 1}
                                    </Pagination.Item>
                                )
                            )}
                            <Pagination.Next onClick={handleNextPage}>
                                <FontAwesomeIcon icon={faAnglesRight} />
                            </Pagination.Next>
                        </Pagination>
                    </div>

                    {/* Modal xóa */}
                    <Modal show={showDeleteModal} onHide={handleCloseDeleteModal}>
                        <Modal.Header closeButton>
                            <Modal.Title>Xác nhận xóa</Modal.Title>
                        </Modal.Header>
                        <Modal.Body>
                            Bạn có chắc chắn muốn xóa phòng{" "}
                            <strong>{roomToDelete?.tenBaiHat}</strong>?
                        </Modal.Body>
                        <Modal.Footer>
                            <Button variant="secondary" onClick={handleCloseDeleteModal}>
                                Hủy
                            </Button>
                            <Button variant="danger" onClick={handleDelete}>
                                Xóa
                            </Button>
                        </Modal.Footer>
                    </Modal>

                    {/* Model xem chi tiết */}
                    <Modal show={showDetailsModal} onHide={handleCloseDetailsModal}>
                        <Modal.Header closeButton>
                            <Modal.Title>Chi tiết sản phẩm</Modal.Title>
                        </Modal.Header>
                        <Modal.Body>
                            <p>
                                <strong>Tên:</strong> {roomToView?.tenBaiHat}
                            </p>
                            <hr />
                            <p>
                                <strong>Số điện thoại:</strong> {roomToView?.caSi}
                            </p>
                            <hr />
                            <p>
                                <strong>Ngày bắt đầu:</strong> {roomToView?.nhacSi}
                            </p>
                            <hr />
                            <p>
                                <strong>Hình thức thanh toán:</strong> {roomToView?.thoiGianPhat}
                            </p>
                            <hr />
                            <p>
                                <strong>Note:</strong> {roomToView?.soLuotThich}
                            </p>
                            <p>
                                <strong>Note:</strong> {roomToView?.trangThai}
                            </p>
                        </Modal.Body>
                        <Modal.Footer>
                            <Button
                                className="btn btn-danger"
                                onClick={handleCloseDetailsModal}
                            >
                                Đóng
                            </Button>
                        </Modal.Footer>
                    </Modal>
                </div>
            </div>
        </div>
    );
}

export default List;
