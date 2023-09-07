import React from 'react';

import BackGround from '../assets/main_back2.jpg'

const Intro_Escrow = () => {
    return (
        <div className='bg-cover bg-center bg-[#BC614B] object-fill max-w-[1240px] mx-auto items-center text-white whitespace-nowrap h-fit' style={{
            backgroundImage: `url(${BackGround})`, height:'500px', backgroundPosition: "center", width:'100%', opacity: 0.8}}>
            <h4 className='invisible'>_</h4>
            <h2 className='mt-8 text-3xl text-center text-[rgb(210,48,44)] font-bold'>에스크로란?</h2>
            <h3 className='mt-8 text-lg text-center font-bold'>
                에스크로 사업자인 페이투스가<br />
                구매자의 결제대금을 예치하고<br />
                구매확인 의사 통보 후<br />
                판매자(쇼핑몰)에게 결제대금 입금하는<br />
                구매보호 시스템
            </h3>
            <div className='max-w-[1240px] mx-auto mt-8 px-6 grid md:grid-cols-2 gap-8'>
                <div className='flex items-center flex-col rounded-lg hover:scale-105 duration-300'>
                    <button className='bg-[#F1511F] w-[200px] rounded-md font-bold mx-auto px-3 py-3 text-white text-bold text-lg text-center'>서비스 신청하기</button>
                </div>
                <div className='flex items-center mb-8 flex-col rounded-lg hover:scale-105 duration-300'>
                    <button className='bg-[#D2302C] w-[200px] rounded-md font-bold mx-auto px-3 py-3 text-white text-bold text-lg text-center'>에스크로 가입확인</button>
                </div>
            </div>
        </div>
    )
};

export default Intro_Escrow;