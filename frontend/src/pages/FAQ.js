import React from 'react';

import Navbar from '../components/Navbar';
import Intro from '../components/Intro';
import Footer from '../components/Footer';
import Form from '../components/Form';

import Back1 from '../assets/main_back1.jpg'

const FAQ = () => {
    return (
        <div className='bg-white'>
            <Navbar />
            <Intro img={Back1} title='문의하기' text1='고객의 목소리에 항상' text2 = '귀 기울이는 페이투스' />
            <div className='object-fill max-w-[1240px] mx-auto px-4 whitespace-nowrap h-fit'>
                <div className='mb-12 mt-12'>
                    <h3 className='text-right font-bold'>문의하신 내용에 대한 답변은 <br/>입력하신 이메일로 회신될 예정입니다.</h3>
                    <br />
                    <hr />
                </div>
            </div>
            <h3 className='object-fill font-bold max-w-[1240px] mx-auto px-4 whitespace-nowrap h-fit text-right'>
                <span className='text-[#F1511F] font-bold'>*</span>표시는 필수 입력 항목입니다.<br />
            </h3>
            <Form/>
            <Footer />
        </div>
    )
};

export default FAQ;