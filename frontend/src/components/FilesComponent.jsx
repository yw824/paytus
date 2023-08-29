import React, {useState, useEffect} from 'react';
import axios from 'axios';

import '../assets/Modal.css';

const NoticeComponent = () => {
    const [data, setData] = useState([]);
    const [modal, setModal] = useState(false);

    const toggleModal = () => {
        setModal(!modal);
    }

    useEffect(() => {
        axios.get('/api/data')
            .then(response => setData(response.data.list))
            .catch(error => console.log(error))
    }, []);

    const downloadImage = (seq) => {
        const url = "/api/data/download/"+seq;
        const download = document.createElement('a');

        download.href = url;
        download.setAttribute('download', seq);
        download.setAttribute('type', 'application/json');
        download.click();
    }
    return (
        <div className='object-fill max-w-[1240px] min-w-fit mx-auto bg-white text-bold whitespace-nowrap h-fit'>
            <div>
                <p className='mt-4 text-3xl mx-3 py-3 font-bold text-gray-400'>- 자료실</p>
                <hr className='text-gray-400 mt-2 mb-2' />
            </div>
            <p className='mx-3 mt-2 py-3 font-bold'>총 <span className='text-[#BC614B] font-bold'>{data.length}</span>건</p>
            <br />
            <div className='mt-4 flex-col mx-auto my-auto grid md:grid-cols-5 gap-4 text-center grid-flow-dense bg-gray-300 py-3 px-3 font-bold whitespace-nowrap'>
                <p className='font-bold col-1'>번호</p>
                <p className='font-bold col-2'>작성자</p>
                <p className='font-bold col-start-3 col-end-5'>파일명</p>
                <p className='font-bold col-5'>등록일</p>
            </div>
            {
                data.map((datum, index) => {
                    // const url = '/api/data/download' + datum.dataseq;
                    return (
                            <div className=
                                     {(index) % 2 != 0
                                         ? 'mt-4 flex-col mx-auto grid md:grid-cols-5 gap-4 text-center py-3 px-3 font-bold grid-flow-dense'
                                         : 'mt-4 flex-col mx-auto grid md:grid-cols-5 gap-4 text-center py-3 px-3 font-bold grid-flow-dense bg-[#BC614B] bg-opacity-70 '
                                     }
                                 key={datum.dataseq} onClick={toggleModal}>
                                <p className='col-1'>{index}</p>
                                <p className='col-2'>{datum.adminid}</p>
                                <button className='col-start-3 col-end-5'
                                        onClick={() => downloadImage(datum.dataseq)}
                                >{datum.datatitle}</button>
                                <p className='col-start-5'>{datum.datadate.slice(0, 10)}</p>
                            </div>
                    )})
            }
        </div>
    )
};

export default NoticeComponent;