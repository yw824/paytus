import React from 'react';
import { SlEarphonesAlt, SlDocs } from "react-icons/sl";

import BackGround from '../assets/main_to_faq.jpg';
import { BrowserRouter as Router, Route, Link } from 'react-router-dom';

const Main_to_FAQ = () => {
    return (
        <div className='bg-cover bg-center bg-[#BC614B] object-fill max-w-[1240px] mx-auto px-4 py-4 items-center text-white whitespace-nowrap h-fit' style={{
            backgroundImage: `url(${BackGround})`, width: 'fill', height:'100%', backgroundPosition: "center", backgroundRepeat: 'no-repeat', opacity: 0.7}}>
            <br />
            <Link to="/faq" target="_blank" className='hover:scale-105 duration-300 hover:text-[#D2302C] max-w-[1240px] mx-auto grid md:grid-cols-6 rounded-lg'>
                <SlDocs size={100} className='col-start-3 col-end-4 place-items-center mx-auto my-auto text-black'/>

                <div className='w-full flex flex-col justify-center col-start-4 col-end-5'>
                    <p className=' font-bold'></p>
                    <h1 className='md:text-4xl text-[#D2302C] sm:text-3xl text-2xl mx-auto my-auto font-bold py-2 '>문의 게시판</h1>
                    <p className='text-black text-center mt-4 mb-4 w-fit-to-content font-bold text-2xl'>
                        궁금하신 사항을 빠르고 <br />정확하게 전달해 드립니다.
                    </p>
                    <button className=' w-[200px] rounded-md text-2xl font-bold my-6 mx-auto py-3 bg-[#F1511F] text-white'>문의하기</button>
                </div>
            </Link>
        </div>
    )
};

export default Main_to_FAQ;

// <img className='w-[500px] mx-auto my-4' src={SlEarphonesAlt} alt="/LaptopImage" />