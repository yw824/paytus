import React from 'react';

import Intro_Complimentary from '../components/Intro_Complimentary'
import Intro_Escrow from './Intro_Escrow';
import Intro_CashReceipts from '../components/Intro_CashReceipts'

import Card from '../assets/1_card.gif'
import Transfer from '../assets/2_transfer.gif'
import Account from '../assets/3_account.gif'
import Phone from '../assets/4_phone.gif'


const Services = () => {
    return (
        <div className='bg-cover bg-center bg-white object-fill max-w-[1240px] text-[#BC614B] mx-auto items-center whitespace-nowrap h-fit'>
            <h4 className='invisible'>_</h4>
            <h2 className='mt-8 font-bold mx-8 text-2xl'>Payment Services</h2>

            <div className='max-w-[1240px] mx-auto font-bold' style={{width:'100%', height: '100%', opacity: 0.8}}>
                <div className='py-[6rem] grid md:grid-cols-2 gap-8'>
                    <div className='hover:scale-105 duration-300'>
                        <img className='rounded-lg mx-auto' src={Card} />
                        <br />
                        <h2 className='text-center text-xl'>신용카드</h2>
                    </div>
                    <div className='hover:scale-105 duration-300'>
                        <img className='rounded-lg mx-auto' src={Transfer} />
                        <br />
                        <h2 className='text-center text-xl'>계좌이체</h2>
                    </div>
                </div>
                <div className='py-[6rem] grid md:grid-cols-2 gap-8'>
                    <div className='hover:scale-105 duration-300'>
                        <img className='rounded-lg mx-auto' src={Account} />
                        <br />
                        <h2 className='text-center text-xl'>가상계좌</h2>
                    </div>
                    <div className='hover:scale-105 duration-300'>
                        <img className='rounded-lg mx-auto' src={Phone} />
                        <br />
                        <h2 className='text-center text-xl'>휴대폰 결제</h2>
                    </div>
                </div>
            </div>
            <h4 className='invisible'>_</h4>
            <Intro_Complimentary />
            <Intro_Escrow />
            <Intro_CashReceipts />
        </div>
    );
};

export default Services;