import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
// thực hành 1
// const name = "Your name";
//thực hành 2
// const fruits = ["Apple",
//                 "Banana",
//                 "Orange",
//                 "Apricot",
//                 "Black rowan",
//                 "Cranberry"];
//thực hành 3
const root = ReactDOM.createRoot(document.getElementById('root'));
//Thực hành 2
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
    //Thực hành 1
  //   React.createElement("h1", {style: {textAlign: "center"}}, name

    //
    // <div>
    //     <h1>List of fruits</h1>
    //     <ul>
    //         {fruits.map(item =>(
    //             <li>{item}</li>
    //         ))}
    //     </ul>
    // </div>
// );
//thực hành 3
// const  tick = () => {
//     root.render(
//         <div>
//             <h1>Hello, Work!</h1>
//             <h2>It is {new Date().toLocaleDateString()}.</h2>
//         </div>
//     );
// };
// setInterval(tick,10);
// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
