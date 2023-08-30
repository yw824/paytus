import React, { useCallback, useState, useEffect } from 'react';
import axios from 'axios';

const Form_Admin_Notices = () => {
    const [admins, setAdmins] = useState([]);

    useEffect(() => {
        axios.get('/api/admin')
            .then(response => setAdmins(response.data.list))
            .catch(error => console.log(error))
    }, []);

    const [notice, setNotice] = useState({adminid: "", noticetext: "", noticetitle: "", noticeurl: ""});
    const [writer, setWriter] = useState({adminid: "", adminpw: ""});
    const [file, setFile] = useState(null);

    let granted = false;

    const handleDataChange = (e) => {
        const name = e.target.name;
        const value = e.target.value;
        console.log("handleChange: " + name + ", " + value);

        setNotice({...notice, [name]: value});
        console.log("Current data// adminid: " + notice.adminid + '/datatitle: ' + notice.noticetitle + "/noticetext: " + notice.noticetext + '/noticelink: ' + notice.noticelink);
    }

    const handleIdChange = (e) => {
        handleDataChange(e);
        handleWriterChange(e);
    }

    const handleWriterChange = (e) => {
        let name = e.target.name;
        let value = e.target.value;
        console.log("handleWriterChange: " + name + ", " + value);
        setWriter({...writer, [e.target.name]: e.target.value});
        console.log("Current Writer// adminid-" + writer.adminid + "/adminpw-" + writer.adminpw);
    }

    const handleSubmit = (e) => {
        e.preventDefault();

        for(let admin of admins){
            if(admin.adminid === writer.adminid && admin.adminpw === writer.adminpw)
            {
                granted = true;
                break;
            }
            granted = false;
        };

        if(!granted) {
            alert("NOT GRANTED!!!");
            return;
        }
        alert("GRANTED: " + notice.adminid + ", " + notice.noticetitle + ", " + notice.noticetext + ", " + notice.noticeurl); // datalink null

        axios.post("/api/notice", notice)
            .then((response) => {
                console.log("completed!!!");
            }).catch(function (error) {
            console.log(error);
        });
    };

    return (
        <div>
            <form enctype="multipart/form-data" className='border-gray-300 flex flex-col shadow-sm max-w-[1240px] my-auto mx-auto bg-white whitespace-nowrap h-fit' method='post' onSubmit={handleSubmit}>

                <h1 className='mt-4 font-bold'>작성자 아이디<span className='text-[#F1511F]'>*</span></h1>
                <input className='w-full py-2 px-2 rounded-md bg-white border-2' type="text" name='adminid' id='' onChange={handleIdChange} placeholder='작성자 아이디'/>

                <h1 className='mt-4 font-bold'>작성자 비밀번호<span className='text-[#F1511F]'>*</span></h1>
                <input className='w-full py-2 px-2 rounded-md bg-white border-2' type="password" name='adminpw' id='' onChange={handleWriterChange} placeholder='작성자 비밀번호'/>

                <h1 className='mt-4 font-bold'>제목<span className='text-[#F1511F]'>*</span></h1>
                <input className='w-full py-2 px-2 rounded-md bg-white border-2' type="text" name='noticetitle' id='' onChange={handleDataChange} placeholder='공지사항 제목을 입력하세요.'/>

                <h1 className='mt-4 font-bold'>내용<span className='text-[#F1511F]'>*</span></h1>
                <textarea className='w-full py-2 px-2 rounded-md bg-white border-2' name="noticetext" id='noticetext' cols='30' onChange={handleDataChange} value={""} rows='10' placeholder='type here......'></textarea>

                <h1 className='mt-4 font-bold'>관련 자료실 주소(URL)<span className='text-[#F1511F]'>*</span></h1>
                <input className='w-full py-2 px-2 rounded-md bg-white border-2' type="url" name='noticeurl' id='' onChange={handleDataChange} placeholder='데이터 제목'/>

                <button className='mt-4 mb-4 w-full h-full px-3 py-3 col-start-5 col-end-6 my-auto mx-auto text-center bg-[#F1511F] rounded-md font-bold text-white text-xl' type='submit' onSubmit={handleSubmit}>SEND</button>
            </form>
        </div>
    )
};

export default Form_Admin_Notices;