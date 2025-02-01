import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Navbar from "../../components/navbar/Navbar";

const Admin = () => {
  const navigte = useNavigate();
  const [messages, setMessages] = useState([]);

  const BASE_URL =
    import.meta.env.VITE_LOGIN_APP_BASE_URL + "/api/messages/private/messages";


    const handleDeleteMsgById = (id)=>{
      const token = localStorage.getItem("token");
      axios.delete(BASE_URL+"/"+id, {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      }).then((e)=>{

        console.log(res.data)
      }).catch((e)=>{
        console.log(e)
      })
        }

useEffect(()=>{
  document.title = "Admin"
},[])

  useEffect(() => {
    const token = localStorage.getItem("token");
    axios
      .get(BASE_URL, {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      })
      .then((res) => {
        setMessages(res.data.data);
        console.log(res.data.data);
      })
      .catch((res) => {
        localStorage.removeItem("token");
        navigte("/login");
      });
  }, []);

  const handleLogout = () => {
    localStorage.removeItem("token");

    navigte("/");
  };




  return (
    <>
      <Navbar validate={true} func={handleLogout}></Navbar>
      <div className="messages">
        <div className="msg-box">
          {messages.length > 0 ? (
            messages.map((m, index) => (
              <div className="m-box" key={index}>
                <h2>Messages:</h2>
                <h2>Mail : {m.email}</h2>
                <p>Mesaj : {m.message}</p>
                <p>Tarih : {m.createdAt}</p>
                <button onClick={(e)=>{
                  handleDeleteMsgById(m.messageId)
                }}>Delete</button>
              </div>
            ))
          ) : (
            <p>Mesaj bulunamadı.</p>
          )}
        </div>
      </div>
    </>
  );
};
export default Admin;
