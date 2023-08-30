import React from 'react';
import Navbar from '../components/Navbar';
import Intro from '../components/Intro';
import Form_Admin_Notices from '../components/Form_Admin_Notices';
import Footer from '../components/Footer';
import BackFAQ from "../assets/main_to_faq.jpg";

const Admin_Notices = () => {
    return (
        <div>
            <Navbar />
            <Intro img={BackFAQ} title='공지사항 업로드' text1='고객의 목소리에 항상' text2 = '귀 기울이는 페이투스' />
            <Form_Admin_Notices />
            <Footer />
        </div>
    )
};

export default Admin_Notices;
