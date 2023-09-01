import React, { useState } from 'react';
import Intro from './Intro';
import { BsChevronCompactLeft, BsChevronCompactRight } from 'react-icons/bs';
import { RxDotFilled } from 'react-icons/rx';

import Back1 from '../assets/main_back1.jpg';
import Back2 from '../assets/main_back2.jpg';
import Back3 from '../assets/main_back3.jpg';

const Main_Slide = () => {

    const slides = [
        {
            component: <Intro img={Back1} title='편리한 전자결제 페이투스' text1='고객의 환경에 적합한 다양한 결제환경과' text2 = '안전한 결제수단을 제공합니다.' />,
            url: Back1,
            title: '편리한 전자결제 페이투스',
            text1: '고객의 환경에 적합한 다양한 결제환경과',
            text2: '안전한 결제수단을 제공합니다.'
        },
        {
            component: <Intro img={Back2} title = '효율적인 통합관리 서비스' text1='편리한 백오피스 시스템을 제공하여' text2 = '효율적인 통합관리 업무를 지원합니다.' />,
            url: Back2,
            title: '효율적인 통합관리 서비스',
            text1: '편리한 백오피스 시스템을 제공하여',
            text2: '효율적인 통합관리 업무를 지원합니다.'
        },
        {
            component: <Intro img={Back3} title='철저한 보안관리 시스템' text1='시스템 완벽한 보안관리 시스템으로' text2 = '고객과 가맹점의 결제를 지원합니다.' />,
            url: Back3,
            title: '철저한 보안관리 시스템',
            text1: '시스템 완벽한 보안관리 시스템으로',
            text2: '고객과 가맹점의 결제를 지원합니다.'
        }
    ]
    const [currentIndex, setCurrentIndex] = useState(0);

    const prevSlide = () => {
        setCurrentIndex((currentIndex - 1 + slides.length) % slides.length);
    };

    const nextSlide = () => {
        // const isLastSlide = currentIndex === slides.length - 1;
        // const newIndex = isLastSlide ? 0 : currentIndex + 1;
        setCurrentIndex((currentIndex + 1) % slides.length);
    };

    const goToSlide = (slideIndex) => {
        setCurrentIndex(slideIndex);
    };

    return (
        <div className='object-fill max-w-[1240px] flex flex-col mx-auto items-center text-white whitespace-nowrap h-fit w-full m-auto py-16 px-4 relative group'
             style={{ backgroundImage: `url(${slides[currentIndex].url})`, height:'400px', backgroundPosition: "center"}}
        >
            <h2 className='absolute top-[30%] text-4xl text-center'>{slides[currentIndex].title}</h2>
            <h3 className='absolute top-[50%] mt-8 text-xl text-center'>{slides[currentIndex].text1}<br />{slides[currentIndex].text2}</h3>

            {/* Left Arrow */}
            <div className='hidden group-hover:block absolute top-[50%] -translate-x-0 translate-y-[-50%] left-5 text-2xl rounded-full p-2 bg-black/20 text-white cursor-pointer'>
                <BsChevronCompactLeft onClick={prevSlide} size={30} />
            </div>
            {/* Right Arrow */}
            <div className='hidden group-hover:block absolute top-[50%] -translate-x-0 translate-y-[-50%] right-5 text-2xl rounded-full p-2 bg-black/20 text-white cursor-pointer'>
                <BsChevronCompactRight onClick={nextSlide} size={30} />
            </div>
            <div className='flex justify-center py-2 absolute top-[90%] place-items-baseline'>
                {slides.map((slide, slideIndex) => (
                    <div
                        key={slideIndex}
                        onClick={() => goToSlide(slideIndex)}
                        className='text-2xl cursor-pointer'
                    >
                        <RxDotFilled />
                    </div>
                ))}
            </div>
        </div>
    );
}

export default Main_Slide;
