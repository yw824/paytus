import React, { useState } from 'react';
import Navbar from '../components/Navbar';
import Footer from '../components/Footer';
import Intro from '../components/Intro';
import Charts from '../components/Charts';
import Services from '../components/Services'

import Back1 from '../assets/main_back1.jpg'

const Main = () => {
    const [order, setOrder] = useState(0);

    const handleNav = () => {
        setOrder((order + 1) % 3);
    };
    return (
        <div>
            <Navbar />
            <Intro img={Back1} title='편리한 전자결제 페이투스' text1='고객의 환경에 적합한 다양한 결제환경과' text2 = '안전한 결제수단을 제공합니다.' />
            <Charts />
            <Services />
            <Footer />
        </div>
    );
};

export default Main;