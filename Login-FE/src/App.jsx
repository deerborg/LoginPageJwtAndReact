import { useState } from "react";
import "./App.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./pages/home/Home";
import Navbar from "./components/navbar/Navbar";
import Login from "./pages/login/Login";
import PrivateRoute from "./pages/PrivateRoute";
import Admin from "./pages/admin/Admin";
function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home></Home>} />
        <Route path="/login" element={<Login></Login>} />
        <Route
          path="/admin"
          element={
            <PrivateRoute>
              <Admin></Admin>
            </PrivateRoute>
          }
        />
      </Routes>
    </Router>
  );
}

export default App;
