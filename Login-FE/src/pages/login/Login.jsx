import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import Navbar from "../../components/navbar/Navbar";

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState(false);
  const [errMesg, setErrMsg] = useState("");
  const [load, setLoad] = useState(false);
  const [loadMsg, setLoadMsg] = useState("loading");
  const navigte = useNavigate();

  const BASE_URL =
    import.meta.env.VITE_LOGIN_APP_BASE_URL + "/api/auth/public/authenticate";

  const handleLogin = () => {
    setLoad(true);
    const userData = {
      username: username,
      password: password,
    };
    axios
      .post(BASE_URL, userData)
      .then((res) => {
        localStorage.setItem("token", res.data.token);
        setLoad(false);
        navigte("/admin");
      })
      .catch((res) => {
        setError(true);
        if (res.data == null) {
          setErrMsg("Error");
        } else {
          setErrMsg(res.data);
        }
        setLoad(false);
        setTimeout(() => {
          setErrMsg("");
          setError(false);
        }, 2000);
      });
  };
  return (
    <>
      <Navbar></Navbar>
      <div className="login">
        {load && <h2>{loadMsg}</h2>}
        <div className="login-form">
          <label>Username</label>
          <input
            value={username}
            onChange={(e) => {
              setUsername(e.target.value);
            }}
            type="text"
            placeholder="Username"
          ></input>
        </div>
        <div className="login-form">
          <label>Password</label>
          <input
            value={password}
            onChange={(e) => {
              setPassword(e.target.value);
            }}
            type="password"
            placeholder="Password"
          ></input>
        </div>
        <div className="login-form">
          <button onClick={handleLogin}>Login</button>
        </div>

        <div className="login-form">{error && <h2>{errMesg}</h2>}</div>
      </div>
    </>
  );
};
export default Login;
