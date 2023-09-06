import React, { useState } from 'react';
import { AiOutlineClose, AiOutlineMenu } from 'react-icons/ai';
import LOGO from '../assets/paytus_noback.png'
import { Link } from 'react-router-dom';

const Navbar = () => {
    const [nav, setNav] = useState(false);

    const handleNav = () => {
        setNav(!nav);
    };

    return (
        <div className='bg-white flex justify-between items-start h-24 max-w-[1240px] mx-auto text-black'>
            <Link to="/"><img className='w-[10rem] md:flex' src={LOGO} alt='Paytus'/></Link>
            <ul className='hidden md:flex'>
                <li className='p-6 text-md font-bold'><Link to="/">Main</Link></li>
                <li className='p-6 text-md font-bold'><Link to="/payments">결제서비스</Link></li>
                <li className='p-6 text-md font-bold'>부가서비스</li>
                <li className='p-6 text-md font-bold'><Link to="/notices">공지사항</Link></li>
                <li className='p-6 text-md font-bold'><Link to="/files">자료실</Link></li>
                <li className='p-6 text-md font-bold'><Link to="/faq">FAQ</Link></li>
            </ul>
            <div onClick={handleNav} className='block md:hidden'>
                {nav ? <AiOutlineClose className='mr-4 my-4' size={30}/> : <AiOutlineMenu className='mr-4 my-4' size={30} />}
            </div>
            <ul className={nav
                ? 'fixed z-50 left-0 top-0 w-[30%] h-full border-r border-r-gray-900 bg-white ease-in-out duration-500 text-black'
                : 'fixed z-50 ease-in-out duration-500 left-[-100%]'}>
                <li className='flex'>
                    <Link to="/"><img className='w-[10rem] md:flex' src={LOGO} alt='Paytus '/></Link>
                    <AiOutlineClose onClick={handleNav} className='mr-4 my-5 my-2md:flex' size={30}/>
                </li>
                <li className='p-4 text-md font-bold border-b border-gray-600'><Link to="/">Main</Link></li>
                <li className='p-4 text-md font-bold border-b border-gray-600'><Link to="/payments">결제서비스</Link></li>
                <li className='p-4 text-md font-bold border-b border-gray-600'><Link to="/">부가서비스</Link></li>
                <li className='p-4 text-md font-bold border-b border-gray-600'><Link to="/notices">공지사항</Link></li>
                <li className='p-4 text-md font-bold border-b border-gray-600'><Link to="/files">자료실</Link></li>
                <li className='p-4'><Link to="/faq">FAQ</Link></li>
            </ul>
        </div>
    );
};

export default Navbar;
// <img className='ml-2 my-2md:flex w-[150px]' src={LOGO} alt='Paytus '/>