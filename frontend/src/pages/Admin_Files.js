import React from 'react';

import Navbar from '../components/Navbar';
import Intro from '../components/Intro';

import Form_Admin_Files from '../components/Form_Admin_Files';

import Footer from '../components/Footer';

import BackFAQ from '../assets/main_to_faq.jpg';

const Admin_Files = () => {
    return (
        <div>
            <Navbar />
            <Intro img={BackFAQ} title='자료실 업로드' text1='고객의 목소리에 항상' text2 = '귀 기울이는 페이투스' />
            <Form_Admin_Files />
            <Footer />
        </div>
    )
};

export default Admin_Files;