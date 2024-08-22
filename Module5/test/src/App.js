import './App.css';

function App() {
  return (
    <div className="App">
        <div className="row justify-content-around">
            <form id="create" className="col-md-5 bg-light p-3 my-3">
                <h1 className="text-center text-uppercase py-3">Create Student</h1>
                <div className="form-group">
                    <label htmlFor="ten" className="form-label my-2">Tên: </label>
                    <input type={"text"} id="ten" className="form-control" />
                </div>
                <div className="form-group">
                    <label htmlFor="ngaySinh" className="my-2 form-label text-start">Ngày sinh: </label>
                    <input type={"date"} id="ngaySinh" className="form-control" />
                </div>
                <div className="form-check-inline">
                    <label htmlFor="gioiTinh" className="form-label my-2">Giới tính:</label>
                    <div className="form-check-inline ml-2">
                        <input
                            type="radio"
                            id="gioiTinhNam"
                            name="gioiTinh"
                            value="Nam"
                            className="form-check-input"
                        />
                        <label htmlFor="gioiTinhNam" className="form-check-label">Nam</label>
                    </div>
                    <div className="form-check-inline">
                        <input
                            type="radio"
                            id="gioiTinhNu"
                            name="gioiTinh"
                            value="Nữ"
                            className="form-check-input"
                        />
                        <label htmlFor="gioiTinhNu" className="form-check-label">Nữ</label>
                    </div>
                    <div className="form-check-inline">
                        <input
                            type="radio"
                            id="gioiTinhKhac"
                            name="gioiTinh"
                            value="Khác"
                            className="form-check-input"
                        />
                        <label htmlFor="gioiTinhKhac" className="form-check-label">Khác</label>
                    </div>
                </div>
                <div className="form-label">
                    <label htmlFor="diaChi" className="form-label my-2">Địa chỉ:</label>
                    <input type={"text"} id="diaChi" className="form-control" />
                </div>
                <div className="text-center my-4">
                    <input type={"submit"} id="submit" className="btn btn-outline-primary mr-5" value="thêm mới"  />
                    <a href={"/"}role={"button"} className={"btn btn-outline-danger"} >Trở lại</a>
                </div>
            </form>
        </div>

    </div>
  );
}

export default App;
