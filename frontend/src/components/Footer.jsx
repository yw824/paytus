import React from 'react';
import {
  FaDribbbleSquare,
  FaFacebookSquare,
  FaGithubSquare,
  FaInstagram,
  FaTwitterSquare,
} from 'react-icons/fa';
import { BrowserRouter as Router, Route, Link } from 'react-router-dom';

const Footer = () => {
  return (
    <div className='max-w-[1240px] mx-auto py-16 px-4  text-gray-300 bg-[#BC614B]'>
        <div className='lg:col-span-2 grid lg:grid-cols-2 gap-8 mx-8 justify-between'>
            <div className='mx-8'>
                <h1 className='w-full text-4xl font-bold text-white'>Paytus Inc : </h1>
                <p className='py-4 text-3xl'>Global Fintech Integrated <br />Payment Business Corp.</p>
                <br />
                <div>
                    <h6 className='font-medium text-2xl text-white border-b border-white'>Services</h6>
                    <br></br>
                    <ul>
                        <li className='py-2 text-2xl '><Link to="/payments">전자 결제 서비스</Link></li>
                        <li className='py-2 text-2xl '>부가 서비스</li>
                        <li className='py-2 text-2xl '>공지사항 / 자료실</li>
                        <li className='py-2 text-2xl '><Link to="/faq">FAQ Form</Link></li>
                    </ul>
                </div>
            </div>
            <div>
                <h3 className='mx-8'>
                    <span className='text-2xl'>(주) 페이투스</span>
                    <br />
                    <br />
                    주소 : 서울시 금천구 가산디지털로 168, C동 701B호 <br />
                        (가산동, 우림라이온스밸리) <br />
                        <br />
                    대표이사 : 서동균 <br />
                    사업자번호 : 810-81-00347 <br />
                    대표전화 : 02-460-8800 | FAX : 02-465-8802 <br />
                    E-mail : sales@paytus.co.kr <br />
                    <br />
                    고객센터 : <br /> 
                    전화 : 02-465-8400 | 평일 09 : 00 ~ 18 : 00 <br />
                    <br />
                    Copyright © PAYTUS Inc. All rights Reserved. <br />
                    <br />
                    개인정보취급방침 | 서비스이용약관 | 통신과금 이용약관 
                </h3>
            </div>
        </div>
        <br /><hr className='max-w-[1240px] px-4 mx-aut'/><br />
        <div className='lg:col-span-2 flex justify-between items-center my-6 px-4 mx-auto'>
            <FaFacebookSquare size={30} />
            <FaInstagram size={30} />
            <FaTwitterSquare size={30} />
            <FaGithubSquare size={30} />
            <FaDribbbleSquare size={30} />
        </div>
    </div>
  );
};

export default Footer;



