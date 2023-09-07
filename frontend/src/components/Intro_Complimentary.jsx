import React from 'react';

import BackGround from '../assets/main_back1.jpg'

const Intro_Complimentary = () => {
    return (
        <div className='bg-cover bg-center bg-[#BC614B] object-fill max-w-[1240px] mx-auto items-center text-white whitespace-nowrap h-fit' style={{
            backgroundImage: `url(${BackGround})`, height:'300px', backgroundPosition: "center", opacity: 0.8}}>
            <h4 className='invisible'>_</h4>
            <h2 className='w-16 md:w-32 lg:w-48 mt-8 mx-8 text-xl font-bold flex flex-col'>Complimentary<br />Services</h2>
            <div className='max-w-[1240px] mx-auto grid md:grid-cols-2 gap-4s mt-4'>
                <div className='flex flex-col p-4 rounded-lg hover:scale-105 duration-300'>
                    <button className='bg-[#F1511F] w-[200px] rounded-md font-bold mx-auto px-6 py-3 text-white'>에스크로</button>
                </div>
                <div className='flex flex-col p-4 rounded-lg hover:scale-105 duration-300'>
                    <button className='bg-[#D2302C] w-[200px] rounded-md font-bold mx-auto px-6 py-3 text-white'>현금영수증 서비스</button>
                </div>
            </div>
        </div>
    )
};

export default Intro_Complimentary;