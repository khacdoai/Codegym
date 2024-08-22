import { initializeApp } from "firebase/app";
import { getStorage, ref, uploadBytes, getDownloadURL } from "firebase/storage";

// Your web app's Firebase configuration
const firebaseConfig = {
    apiKey: "AIzaSyB5tqnfB6-jFckzCkQ6QMYrvXBKlibTp0s",
    authDomain: "cinema-1a241.firebaseapp.com",
    databaseURL: "https://cinema-1a241-default-rtdb.asia-southeast1.firebasedatabase.app",
    projectId: "cinema-1a241",
    storageBucket: "cinema-1a241.appspot.com",
    messagingSenderId: "5121200364",
    appId: "1:5121200364:web:d5248dbcc577ca2aead5c9",
    measurementId: "G-JJPVQJFEXW"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const storage = getStorage(app);

export { storage, ref, uploadBytes, getDownloadURL };
