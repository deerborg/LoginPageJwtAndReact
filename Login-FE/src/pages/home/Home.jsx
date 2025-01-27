import axios from "axios";
import { useState } from "react";
import Navbar from "../../components/navbar/Navbar";

const Home = () => {
  const [email, setEmail] = useState("");
  const [msg, setMsg] = useState("");

  const BASE_URL =
    import.meta.env.VITE_LOGIN_APP_BASE_URL + "/api/messages/public/send";

  const handleSend = () => {
    const msgData = {
      email: email,
      message: msg,
    };
    axios
      .post(BASE_URL, msgData)
      .then((res) => {
        console.log(res.data);
      })
      .catch((res) => {
        console.log(res.response.data.message);
      });
  };

  return (
    <>
      <Navbar></Navbar>
      <section className="home">
        <h1>Contents</h1>
        <div className="home-content">
          <p>
            Lorem ipsum dolor sit, amet consectetur adipisicing elit. Molestiae,
            corrupti. Illum ipsa mollitia obcaecati maxime voluptatibus a
            reprehenderit, pariatur sequi, ipsam nulla ullam praesentium dolorum
            nesciunt quaerat iure? Adipisci, asperiores.
          </p>

          <p>
            Lorem ipsum dolor sit, amet consectetur adipisicing elit. Molestiae,
            corrupti. Illum ipsa mollitia obcaecati maxime voluptatibus a
            reprehenderit, pariatur sequi, ipsam nulla ullam praesentium dolorum
            nesciunt quaerat iure? Adipisci, asperiores.
          </p>

          <p>
            Lorem ipsum dolor sit, amet consectetur adipisicing elit. Molestiae,
            corrupti. Illum ipsa mollitia obcaecati maxime voluptatibus a
            reprehenderit, pariatur sequi, ipsam nulla ullam praesentium dolorum
            nesciunt quaerat iure? Adipisci, asperiores.
          </p>
          <p>
            Lorem ipsum dolor sit, amet consectetur adipisicing elit. Molestiae,
            corrupti. Illum ipsa mollitia obcaecati maxime voluptatibus a
            reprehenderit, pariatur sequi, ipsam nulla ullam praesentium dolorum
            nesciunt quaerat iure? Adipisci, asperiores.
          </p>

          <p>
            Lorem ipsum dolor sit, amet consectetur adipisicing elit. Molestiae,
            corrupti. Illum ipsa mollitia obcaecati maxime voluptatibus a
            reprehenderit, pariatur sequi, ipsam nulla ullam praesentium dolorum
            nesciunt quaerat iure? Adipisci, asperiores.
          </p>

          <p>
            Lorem ipsum dolor sit, amet consectetur adipisicing elit. Molestiae,
            corrupti. Illum ipsa mollitia obcaecati maxime voluptatibus a
            reprehenderit, pariatur sequi, ipsam nulla ullam praesentium dolorum
            nesciunt quaerat iure? Adipisci, asperiores.
          </p>
          <p>
            Lorem ipsum dolor sit, amet consectetur adipisicing elit. Molestiae,
            corrupti. Illum ipsa mollitia obcaecati maxime voluptatibus a
            reprehenderit, pariatur sequi, ipsam nulla ullam praesentium dolorum
            nesciunt quaerat iure? Adipisci, asperiores.
          </p>

          <p>
            Lorem ipsum dolor sit, amet consectetur adipisicing elit. Molestiae,
            corrupti. Illum ipsa mollitia obcaecati maxime voluptatibus a
            reprehenderit, pariatur sequi, ipsam nulla ullam praesentium dolorum
            nesciunt quaerat iure? Adipisci, asperiores.
          </p>

          <p>
            Lorem ipsum dolor sit, amet consectetur adipisicing elit. Molestiae,
            corrupti. Illum ipsa mollitia obcaecati maxime voluptatibus a
            reprehenderit, pariatur sequi, ipsam nulla ullam praesentium dolorum
            nesciunt quaerat iure? Adipisci, asperiores.
          </p>
          <p>
            Lorem ipsum dolor sit, amet consectetur adipisicing elit. Molestiae,
            corrupti. Illum ipsa mollitia obcaecati maxime voluptatibus a
            reprehenderit, pariatur sequi, ipsam nulla ullam praesentium dolorum
            nesciunt quaerat iure? Adipisci, asperiores.
          </p>

          <p>
            Lorem ipsum dolor sit, amet consectetur adipisicing elit. Molestiae,
            corrupti. Illum ipsa mollitia obcaecati maxime voluptatibus a
            reprehenderit, pariatur sequi, ipsam nulla ullam praesentium dolorum
            nesciunt quaerat iure? Adipisci, asperiores.
          </p>

          <p>
            Lorem ipsum dolor sit, amet consectetur adipisicing elit. Molestiae,
            corrupti. Illum ipsa mollitia obcaecati maxime voluptatibus a
            reprehenderit, pariatur sequi, ipsam nulla ullam praesentium dolorum
            nesciunt quaerat iure? Adipisci, asperiores.
          </p>
          <p>
            Lorem ipsum dolor sit, amet consectetur adipisicing elit. Molestiae,
            corrupti. Illum ipsa mollitia obcaecati maxime voluptatibus a
            reprehenderit, pariatur sequi, ipsam nulla ullam praesentium dolorum
            nesciunt quaerat iure? Adipisci, asperiores.
          </p>
        </div>

        <div className="feedback-form">
          <h1>Feedback Form</h1>
          <div className="form-box">
            <label>Email</label>
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
              value={msg}
              onChange={(e) => {
                setMsg(e.target.value);
              }}
            ></textarea>
          </div>

          <div className="form-box">
            <button onClick={handleSend}>Send</button>
          </div>
        </div>
      </section>
    </>
  );
};
export default Home;
