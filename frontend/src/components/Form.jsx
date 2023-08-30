import React, {useState} from 'react';
import axios from 'axios';

const Form = () => {
    const [data, setData] = useState({faqarea: "", faqcorp: "", faqname: "", faqemail: "", faqcall: "", faqtext: "", faqterm: 0, faqisnew: 0});

    const handleChange = (e) => {
        const name = e.target.name;
        let value = e.target.value;

        if(name == "faqisnew" || name == 'faqterm') {
            if (value == 'on')
                value = 1;
            else
                value = 0;
        }
        setData({...data, [name]: value});
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(data);
        axios.post("/api/faq", data)
            .then((response) => {
                alert("completed!!!");
                window.location.replace('/faq');
            }).catch(function (error) {
                alert(error);
        });
    };

    return (
        <div className='max-w-[1240px] mx-auto px-2 flex flex-col'>
            <form className='border-gray-300 flex flex-col shadow-sm max-w-[1240px] my-auto mx-auto bg-white whitespace-nowrap h-fit' method='post' onSubmit={handleSubmit}>
                <h1 className='mt-4 font-bold'>유형 선택 <span className='text-[rgb(241,81,31)]'>*</span></h1>
                <select className='w-full flex flex-col py-2 px-2 rounded-md bg-white border-2 my-2 object-fill max-w-[1240px] mx-auto font-bold whitespace-nowrap h-fit' type='text' name='faqarea' onChange={handleChange} value={data.type}>
                    <option value="etc">신고/기타</option>
                    <option value="payment">결제 서비스</option>
                    <option value="complimentary">부가 서비스</option>
                    <option value="notice">자료실</option>
                </select>
                <h1 className='mt-4 font-bold'>회사명 <span className='text-[#F1511F]'>*</span></h1>
                <input className='w-full py-2 px-2 rounded-md bg-white border-2' type="text" name='faqcorp' id='faqcorp' onChange={handleChange} value={data.company} placeholder='회사명'/>
                <div className='w-full max-w-[1240px] mx-auto grid md:grid-cols-3 gap-4'>
                    <div className='col-1 w-full'>
                        <h1 className='mt-4 font-bold'>성명 <span className='text-[#F1511F]'>*</span></h1>
                        <input className='w-full py-2 px-2 rounded-md bg-white border-2' type="text" name='faqname' id='faqname' onChange={handleChange} value={data.name} placeholder='성명'/>
                    </div>
                    <div className='col-start-2 col-end-4'>
                        <h1 className='mt-4 font-bold'>연락처 <span className='text-[#F1511F]'>*</span></h1>
                        <input className='w-full py-2 px-2 rounded-md bg-white border-2' type="phone" name='faqcall' id='faqcall' onChange={handleChange} value={data.phone} placeholder='0##-####-####'/>
                    </div>
                </div>
                <h1 className='mt-4 font-bold'>이메일 <span className='text-[#F1511F]'>*</span></h1>
                <input className='w-full py-2 px-2 rounded-md bg-white border-2' type="email" name='faqemail' id='faqemail' onChange={handleChange} value={data.email} placeholder='Enter Your Email'/>
                <h1 className='mt-4 font-boldp'>문의 내용 <span className='text-[#F1511F]'>*(최대 2000자)</span></h1>
                        <textarea className='w-full py-2 px-2 rounded-md bg-white border-2' name='faqtext' id='faqtext' cols='30' onChange={handleChange} value={data.message} rows='10' placeholder='type here......'></textarea>
                        <div className='my-8 max-w-[1240px] grid md:grid-cols-7 gap-4'>
                            <div className='col-start-2 col-end-5'>
                                <div className='mx-auto grid md:grid-cols-5 ga-4'>
                            <label className='text-l font-bold mx-auto my-auto col-start-1 col-end-3' for="faqterm" onChange={handleChange}>개인정보 제공 및 활용 동의(필수)</label>
                            <input className='col-start-5 whitespace-nowrap' type='checkbox' name='faqterm' id='faqterm' onChange={handleChange}/>
                        </div>
                        <br />
                        <div className='mx-auto grid md:grid-cols-5 gap-4'>
                            <label className='text-l font-bold mx-auto my-auto col-start-1 col-end-3' for="faqisnew" onChange={handleChange}>페이투스 서비스 사용 중입니까?</label>
                            <input className='col-start-5 whitespace-nowrap' type='checkbox' name='faqisnew' id='faqisnew' onChange={handleChange}/>
                        </div>
                    </div>
                    <button className='w-full h-full px-3 py-3 col-start-5 col-end-6 my-auto mx-auto text-center bg-[#F1511F] rounded-md font-bold text-white text-xl' type='submit' onSubmit={handleSubmit}>SEND</button>
                </div>
            </form>
        </div>
    )
};

export default Form;