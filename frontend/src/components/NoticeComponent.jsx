import React, {useState, useEffect} from 'react';
import axios from 'axios';
import {AiOutlineCloseSquare} from 'react-icons/ai';

const NoticeComponent = () => {
    const [notices, setNotices] = useState([]);
    const [modal, setModal] = useState(false);
    const [data, setData] = useState({
        noticeseq: 200,
        adminid: "none",
        noticetitle: "NoTitle",
        noticetext: "noText",
        noticedate: "noDate",
        noticeurl: "nourl"
    });

    const toggleModal = () => {
        setModal(!modal);
    }

    useEffect(() => {
        axios.get('/api/notice')
            .then((response) => {
                setNotices(response.data.list);
            }) .catch(error => console.log(error))
    }, []);

    const showModal = (seq) => {
        console.log(seq);
        axios.get('/api/notice/' + seq)
            .then((response) => setData(response.data.data))
            .catch((error) => console.log(error));
        setModal(true);
    }

    const deleteContent = (seq) => {
        if (window.confirm("정말 삭제합니까?")) {
            axios.delete('/api/notice/' + seq)
                .then(() => console.log("delete completed"))
                .catch((error) => console.log(error));
            alert("공지사항 삭제 완료");
            window.location.replace('/notices'); // 삭제되었으므로 리디렉션
        } else {
            alert("취소되었습니다.");
        }
    }

    return (
        <div className='object-fill max-w-[1240px] min-w-fit mx-auto bg-white text-bold whitespace-nowrap h-fit'>
            <div>
                <p className='mt-4 text-3xl mx-3 py-3 font-bold text-gray-400'>- 공지사항</p>
                <hr className='text-gray-400 mt-2 mb-2' />
            </div>
            <p className='mx-3 mt-2 py-3 font-bold'>총 <span className='text-[#BC614B] font-bold'>{notices.length}</span>건</p>
            <br />
            <div className='mt-4 flex-col mx-auto my-auto grid md:grid-cols-6 gap-4 text-center grid-flow-dense bg-gray-300 py-3 px-3 font-bold whitespace-nowrap'>
                <p className='font-bold col-1'>번호</p>
                <p className='font-bold col-2'>작성자</p>
                <p className='font-bold col-start-3 col-end-5'>제목</p>
                <p className='font-bold col-5'>등록일</p>
                <p className='font-bold col-5'>Action</p>
            </div>
            {
                notices.map((notice, index) => {
                    return (
                        <div>
                            <div className=
                                     {(index) % 2 != 0
                                         ? 'mt-4 flex-col mx-auto grid md:grid-cols-6 gap-4 text-center py-3 px-3 font-bold grid-flow-dense'
                                         : 'mt-4 flex-col mx-auto grid md:grid-cols-6 gap-4 bg-[#BC614B] bg-opacity-70 text-center py-3 px-3 font-bold'
                                     }
                                 key={notice.noticeseq}>
                                <p className='col-1 my-auto'>{index}</p>
                                <p className='col-2 my-auto'>{notice.adminid}</p>
                                <button className='col-start-3 col-end-5 my-auto hover:scale-105 duration-300' onClick={() => showModal(notice.noticeseq)}>{notice.noticetitle}</button>
                                <p className='col-5 my-auto'>{notice.noticedate.slice(0, 10)}</p>
                                <AiOutlineCloseSquare className='mr-4 my-4 col-6 mx-auto' size={30} onClick={() => deleteContent(notice.noticeseq)}/>
                            </div>
                            <div className={modal // 생성될 때 notice를 기준으로,, ???
                                ? 'visible'
                                : 'invisible'
                                 }>
                                <>
                                    <div className="flex justify-center items-center overflow-x-hidden overflow-y-auto fixed inset-0 z-50 outline-none focus:outline-none">
                                        <div className="relative w-auto my-6 mx-auto max-w-3xl">
                                            <div className="border-0 rounded-lg shadow-lg relative flex flex-col w-full bg-white outline-none focus:outline-none">
                                                <div className="flex items-start justify-between p-5 border-b border-solid border-gray-300 rounded-t ">
                                                    <h3 className="text-3xl font=semibold">{data.noticeseq}</h3>
                                                    <button
                                                        className="bg-transparent border-0 text-black float-right"
                                                        onClick={() => setModal(false)}
                                                    >
                                                        <span className="hover:scale-105 duration-300 text-black opacity-7 place-items-center h-6 w-6 text-xl block bg-gray-400 py-0 rounded-full">
                                                            <AiOutlineCloseSquare />
                                                        </span>
                                                    </button>
                                                </div>
                                                <div className="relative p-6 flex-auto">
                                                    <p className='font-bold text-xl text-[#BC614B]'>Title</p>
                                                    <div className='font-bold text-xl mx-4 my-4'>{data.noticetitle}</div>
                                                    <hr />
                                                    <p className='font-bold text-xl text-[#BC614B]'>Text</p>
                                                    <div className='font-bold text-xl mx-4 my-4 flex flex-col'>{data.noticetext}</div>
                                                    <hr />
                                                    <p className='font-bold text-xl text-[#BC614B]'>추가 자료실 URL</p>
                                                    <div className='font-bold text-xl mx-4 my-4'>{data.noticeurl}</div>
                                                </div>
                                                <div className="flex items-center justify-end p-6 border-t border-solid border-blueGray-200 rounded-b">
                                                    <button
                                                        className="text-red-500 background-transparent font-bold uppercase px-6 py-2 text-sm outline-none focus:outline-none mr-1 mb-1"
                                                        type="button"
                                                        onClick={() => setModal(false)}
                                                    >
                                                        Close
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </>
                            </div>
                        </div>
                    )})
            }
        </div>
    )
};

export default NoticeComponent;