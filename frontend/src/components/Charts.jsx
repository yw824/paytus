import React from 'react';
import Chart from '../assets/charts.PNG'

const Charts = (props) => {
    return (
        <div className='bg-fixed h-fit flex flex-wrap max-w-[1240px] mx-auto items-center text-white whitespace-nowrap' style={{
            backgroundImage: `url(${Chart})`, backgroundRepeat: 'no-repeat',  backgroundPosition: "center"}}>

            <div className='bg-[#BC614B] max-w-[1240px] mx-auto' style={{width:'100%', height: '100%', opacity: 0.8}}>
                <div className='py-[6rem] grid md:grid-cols-2 gap-8'>
                    <div>
                        <h1 className='text-center text-bold text-3xl'>연매출</h1>
                        <br />
                        <h2 className='text-center text-5xl'>131.8억</h2>
                    </div>
                    <div>
                        <h1 className='text-center text-bold text-3xl'>매출 증가율</h1>
                        <br />
                        <h2 className='text-center text-5xl'>219%</h2>
                    </div>
                </div>
                <div className='py-[4rem] grid md:grid-cols-2 gap-8'>
                    <div>
                        <h1 className='text-center text-bold text-3xl'>누적 가맹점</h1>
                        <br />
                        <h2 className='text-center text-5xl'>25000+</h2>
                    </div>
                    <div>
                        <h1 className='text-center text-bold text-3xl'>영업이익 증가율</h1>
                        <br />
                        <h2 className='text-center text-5xl'>134%</h2>
                    </div>
                </div>
                <div className='py-[4rem] grid md:grid-cols-2 gap-8'>
                    <div>
                        <h1 className='text-center text-bold text-3xl'>영업이익</h1>
                        <br />
                        <h2 className='text-center text-5xl'>13.6억</h2>
                    </div>
                    <div className='invisible'>
                        <h1 className='text-center text-bold text-3xl'>영업이익</h1>
                        <br />
                        <h2 className='text-center text-5xl'>219%</h2>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Charts;