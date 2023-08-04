import React from 'react';
import Navbar from '../components/Navbar';
import Intro from '../components/Intro';
import Footer from '../components/Footer';

import Back1 from '../assets/main_back1.jpg'

const Payments = () => {
    return (
        <div>
            <Navbar />
            <Intro img={Back1} title='결제 서비스' text1='고객의 목소리에 항상 귀 기울이는 페이투스' text2 = '' />
            <Footer />
        </div>
    );
};

export default Payments;
