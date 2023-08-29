import React from 'react';
import Navbar from '../components/Navbar';
import Intro from '../components/Intro';
import Footer from '../components/Footer';
import FilesComponent from '../components/FilesComponent';

import Back1 from '../assets/main_back1.jpg';


const Notice = () => {
    return (
        <div>
            <Navbar />
            <Intro img={Back1} title='자료실' text1='고객의 목소리에 항상' text2 = '귀 기울이는 페이투스'/>
            <FilesComponent />
            <Footer />
        </div>
    )
};

export default Notice;