import './App.css';
import {
    BrowserRouter as Router,
    Route,
    Routes,
} from "react-router-dom";
import ToastContainer from "react-bootstrap/ToastContainer";
import Create from "./component/Create";
import List from "./component/List";
import React from "react";

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
