import { useState } from "react";
import { useNavigate } from "react-router-dom";

const Navbar = ({ validate, func }) => {
  const navigte = useNavigate();

  return (
    <>
      <header className="header">
        <nav className="navbar">
          <div className="logo">LOGO</div>

          <div className="nav-element">
            <a
              onClick={() => {
                navigte("/");
              }}
            >
              Main
            </a>
            <a
              onClick={() => {
                navigte("/login");
              }}
            >
              Login
            </a>
            {validate && <a onClick={func}>Logout</a>}
          </div>
        </nav>
      </header>
    </>
  );
};
export default Navbar;
