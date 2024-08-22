import logo from './logo.svg';
import './App.css';
import {Create} from "./components/Create";
import {List} from "./components/List";
import {Link, NavLink, Route, Routes} from "react-router-dom";
import {ToastContainer} from "react-toastify";
import {Update} from "./components/Update";
import {Page404} from "./components/Page404";

function App() {
  return (
      <>
          {/*<Link to='/'>Home</Link>*/}
          {/*<Link to='/create' className='ms-2'>Create</Link>*/}
          {/* <a href="/create">ABC</a>*/}
          <NavLink to='/'>Home</NavLink>
          <NavLink to='/create' className='ms-2'>Create</NavLink>

          <Routes>
              <Route path='/' element={<List />}></Route>
              <Route path='/create' element={<Create />}></Route>
              <Route path='/edit/:id' element={<Update />}></Route>
              <Route path='*' element={<Page404 />}></Route>
          </Routes>

          <ToastContainer />
      </>
  );
}

export default App;
