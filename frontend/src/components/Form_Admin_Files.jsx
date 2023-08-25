import React, { useCallback, useState, useEffect } from 'react';
import axios from 'axios';

const Form_Admin_Files = () => {
    const [admins, setAdmins] = useState([]);

    useEffect(() => {
        axios.get('/api/admin')
            .then(response => setAdmins(response.data.list))
            .catch(error => console.log(error))
    }, []);

    const [data, setData] = useState({adminid: "", datatitle: "", datalink: null});
    const [writer, setWriter] = useState({adminid: "", adminpw: ""});
    const [file, setFile] = useState(null);

    let granted = false;

    const handleDataChange = (e) => {
        const name = e.target.name;
        const value = e.target.value;
        console.log("handleChange: " + name + ", " + value);

        setData({...data, [name]: value});
        console.log("Current data// adminid-" + data.adminid + '/datatitle-' + data.datatitle + '/datalink-' + data.datalink);
    }

    const handleIdChange = (e) => {
        handleDataChange(e);
        handleWriterChange(e);
    }

    const handleFileChange = (e) => {
        setFile(e.target.files[0]);
        // form에서 파일이 하나만 올려도 form에 파일 선택하면 배열에 저장되어 있음
        // 그래서 개별 파일을 보낼 거면 꺼내서 변수에 저장해야 함 : files 속성에 저장되어 있음
        // 안 그러면 blob 써야 하는데, blob : [object object]로 저장됨
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
                console.log("GRANTED SET");
                break;
            }
            granted = false;
            console.log("GRANT REVOKED");
        };

        if(!granted) {
            alert("NOT GRANTED!!!");
            return;
        }
        alert("GRANTED: " + data.adminid + ", " + data.datalink); // datalink null

        const formData = new FormData();
        formData.append("dto", new Blob([JSON.stringify(data)], {type: "application/json"}));
        formData.append("file", file);
        console.log(formData.get('file'));
        console.log(formData.get('dto'));

        axios.post("/api/data", formData)
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
                <input className='w-full py-2 px-2 rounded-md bg-white border-2' type="text" name='adminid' id='' onChange={handleIdChange} value={data.company} placeholder='작성자 아이디'/>

                <h1 className='mt-4 font-bold'>작성자 비밀번호<span className='text-[#F1511F]'>*</span></h1>
                <input className='w-full py-2 px-2 rounded-md bg-white border-2' type="text" name='adminpw' id='' onChange={handleWriterChange} value={data.company} placeholder='작성자 비밀번호'/>

                <h1 className='mt-4 font-bold'>파일 업로드<span className='text-[#F1511F]'>*</span></h1>
                <input className='w-full py-2 px-2 bg-[#F1511F] bg-opacity-30 rounded-md border-2' type="file" name='datatlink' id=''  onChange={handleFileChange} />

                <h1 className='mt-4 font-bold'>제목<span className='text-[#F1511F]'>*</span></h1>
                <input className='w-full py-2 px-2 rounded-md bg-white border-2' type="text" name='datatitle' id='' onChange={handleDataChange} value={data.company} placeholder='데이터 제목'/>

                <button className='mt-4 mb-4 w-full h-full px-3 py-3 col-start-5 col-end-6 my-auto mx-auto text-center bg-[#F1511F] rounded-md font-bold text-white text-xl' type='submit' onSubmit={handleSubmit}>SEND</button>
            </form>
        </div>
    )
};

export default Form_Admin_Files;