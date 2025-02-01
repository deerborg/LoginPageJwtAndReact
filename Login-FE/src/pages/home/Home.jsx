import axios from "axios";
import { useState } from "react";
import Navbar from "../../components/navbar/Navbar";

const Home = () => {
  const [email, setEmail] = useState("");
  const [msg, setMsg] = useState("");
  const [error,setError] = useState("");
  const [errorStatus,setErrorStatus] = useState(false);
  const [loading,setLoading] = useState("loading");
  const [loadingStats,setLoadStats] = useState(false);

  const BASE_URL =
    import.meta.env.VITE_LOGIN_APP_BASE_URL + "/api/messages/public/send";

  const handleSend = () => {
    setLoading(true);
    const msgData = {
      email: email,
      message: msg,
    };
    axios
      .post(BASE_URL, msgData)
      .then((res) => {
        console.log(res.data);
        setLoading(false);
      })
      .catch((res) => {
        setError(res.response.data.message);
        setErrorStatus(true)
        setTimeout(()=>{
          setError("");
          setErrorStatus(false);
        },2000)
        setLoading(false);
      });
  };

  return (
    <>
      <Navbar></Navbar>
      <section className="home">
      <h1>Feedback Form</h1>
        <div className="feedback-form">
          <div className="load-bar-msg">
            {
              loadingStats && <h2>{loading}</h2>
            }
          </div>
          <div className="form-box">
            
            <label >Email</label>
            <input
              
              value={email}
              onChange={(e) => {
                setEmail(e.target.value);
              }}
              type="email"
              placeholder="example@mail.com"
            ></input>
          </div>

          <div className="form-box">
            <label>Message</label>
            <textarea
            
            placeholder="Give me message"
              value={msg}
              onChange={(e) => {
                setMsg(e.target.value);
              }}
            ></textarea>
          </div>


          <div className="form-box error">
           {errorStatus && <h2>{error}</h2>}
          </div>


          <div className="form-box-button">
            <button onClick={handleSend}>Send</button>
          </div>
      

        </div>
      </section>
    </>
  );
};
export default Home;
