import React from 'react';

import BackGround from '../assets/main_back1.jpg'

const Intro_CashReceipts = () => {
    return (
        <div className='bg-cover bg-center bg-[#BC614B] object-fill max-w-[1240px] mx-auto items-center text-white whitespace-nowrap h-fit' style={{
            backgroundImage: `url(${BackGround})`, height:'100%', backgroundPosition: "center", width:'100%', opacity: 0.8}}>
            <h4 className='invisible'>_</h4>
            <h2 className='mt-8 text-4xl text-center text-[#D2302C] font-bold'>현금영수증 서비스</h2>
            <h3 className='mt-6 mb-2 text-2xl text-center flex flex-col font-bold'>
                국세청 홈페이지에 등록된<br />
                본인 인증 매체를 통해<br />
                현금  결제 내역 현금영수증 요청하면<br />
                전자결제시스템 통해 발행하고<br />
                결제내역은 국세청에 통보되는 제도
            </h3>

            <div className='max-w-[1240px] mx-auto grid md:grid-cols-3'>
                <div className='flex flex-col p-4 rounded-lg hover:scale-105 duration-300'>
                    <h2 className='mt-4 rounded-md font-bold mx-auto text-[#F1511F] text-3xl text-center'>발급수수료<br />무료</h2>
                </div>

                <div className='flex flex-col p-4 rounded-lg hover:scale-105 duration-300'>
                    <h2 className='mt-4 rounded-md font-bold mx-auto text-[#F1511F] text-3xl text-center'>실시간 발급내역<br />조회</h2>
                </div>

                <div className='flex flex-col p-4 rounded-lg hover:scale-105 duration-300'>
                    <h2 className='mt-4 rounded-md font-bold mx-auto text-[#F1511F] text-3xl text-center'>수동<br />발행</h2>
                </div>
            </div>
            <button className='object-fill md:place-items-center justify-between content-center bg-[#D2302C] text-center w-[200px] mt-4 mb-6 rounded-lg font-bold px-3 py-3 text-white text-xl place-items-center'>서비스 신청하기</button>
        </div>
    )
};

export default Intro_CashReceipts;