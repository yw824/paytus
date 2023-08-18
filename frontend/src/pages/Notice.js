import React from 'react';
import Navbar from '../components/Navbar';
import Intro from '../components/Intro';
import Footer from '../components/Footer';
import NoticeComponent from '../components/NoticeComponent';

import Back1 from '../assets/main_back1.jpg';


const Notice = () => {
    return (
        <div>
            <Navbar />
            <Intro img={Back1} title='공지사항' text1='생생하고 빠른 정보를' text2 = '업로드합니다.'/>
            <NoticeComponent />
            <Footer />
        </div>
    )
};

export default Notice;