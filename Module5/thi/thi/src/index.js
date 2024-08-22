import {
  BrowserRouter as Router,
  Route,
  Routes,
} from "react-router-dom";
import List from "./component/List";
import Create from "./component/Create"
// import CreateProduct from "./component/Create/CreateProduct";
// import UpdateProduct from "./component/Update/UpdateProduct";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
function App() {
  return (
      <>
      <Router>
      <Routes>
      <Route path="/" element={<List />} />
  <Route path="/create" element={<Create />} />
  {/* <Route path="/update-product/:id" element={<UpdateProduct />} /> */}
</Routes>
  </Router>
  <ToastContainer />
  </>
);
}

export default App;
import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
