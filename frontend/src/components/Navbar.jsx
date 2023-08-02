import React, { useState } from 'react';
import { AiOutlineClose, AiOutlineMenu } from 'react-icons/ai';
import LOGO from '../assets/paytus_noback.png'

const Navbar = () => {
    const [nav, setNav] = useState(false);

    const handleNav = () => {
        setNav(!nav);
    };

return (
    <div className='flex justify-between items-start h-24 max-w-[1240px] mx-auto text-black'>
        <img className='w-[10rem] md:flex' src={LOGO} alt='Paytus '/>
        <ul className='hidden md:flex'>
            <li className='p-6 text-bold'>Home1</li>
            <li className='p-6 text-bold'>Payments</li>
            <li className='p-6 text-bold'>Complimentary</li>
            <li className='p-6 text-bold'>Notice</li>
            <li className='p-6 text-bold'>FAQ</li>
        </ul>
        <div onClick={handleNav} className='block md:hidden'>
            {nav ? <AiOutlineClose className='mr-4 my-4' size={30}/> : <AiOutlineMenu className='mr-4 my-4' size={30} />}
        </div>
        <ul className={nav ? 'fixed left-0 top-0 w-[60%] h-full border-r border-r-gray-900 bg-[#000300] ease-in-out duration-500 text-white' : 'ease-in-out duration-500 fixed left-[-100%]'}>
            <img className='ml-2 my-2md:flex w-[150px]' src={LOGO} alt='Paytus '/>
            <li className='p-4 border-b border-gray-600'>Home</li>
            <li className='p-4 border-b border-gray-600'>Payments</li>
            <li className='p-4 border-b border-gray-600'>Complimentary</li>
            <li className='p-4 border-b border-gray-600'>Notice</li>
            <li className='p-4'>FAQ</li>
        </ul>
    </div>
    );
};

export default Navbar;
// <h1 className='w-full text-3xl font-bold text-[#F15D3C]'>Paytus</h1> 
// <img className='w-[100px] mx-auto mt-[-3rem] my-8' src={LOGO} alt='Paytus '/>