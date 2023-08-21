import React, {useState, useEffect} from 'react';
import axios from 'axios';

const NoticeComponent = () => {
    const [notices, setNotices] = useState([]);

    useEffect(() => {
        axios.get('/api/notice')
            .then(response => setNotices(response.data.list))
            .catch(error => console.log(error))
    }, []);

    return (
        <div className='object-fill max-w-[1240px] min-w-fit mx-auto bg-white text-bold whitespace-nowrap h-fit'>
            <div>
                <p className='mt-4 text-3xl mx-3 py-3 font-bold text-gray-400'>- 공지사항</p>
                <hr className='text-gray-400 mt-2 mb-2' />
            </div>
            <p className='mx-3 mt-2 py-3 font-bold'>총 <span className='text-[#BC614B] font-bold'>{notices.length}</span>건</p>
            <br />
            <div className='mt-4 flex-col mx-auto my-auto grid md:grid-cols-5 gap-4 text-center grid-flow-dense bg-gray-300 py-3 px-3 font-bold whitespace-nowrap'>
                <p className='font-bold col-1'>번호</p>
                <p className='font-bold col-2'>작성자</p>
                <p className='font-bold col-start-3 col-end-5'>제목</p>
                <p className='font-bold col-5'>등록일</p>
            </div>
            {
                notices.map((notice, index) => {
                    return (
                        <div>
                            <div className=
                                     {(index) % 2 != 0
                                         ? 'mt-4 flex-col mx-auto grid md:grid-cols-5 gap-4 text-center py-3 px-3 font-bold grid-flow-dense'
                                         : 'mt-4 flex-col mx-auto grid md:grid-cols-5 gap-4 bg-[#BC614B] bg-opacity-70 text-center py-3 px-3 font-bold'
                                     }
                                 key={notice.noticeseq}>
                                <p className='col-1'>{index}</p>
                                <p className='col-2'>{notice.adminid}</p>
                                <strong className='col-start-3 col-end-5'>{notice.noticetitle}</strong>
                                <p className='col-start-5'>{notice.noticedate.slice(0, 10)}</p>
                            </div>
                        </div>
                    )})
            }
        </div>
    )
};

export default NoticeComponent;