import React from 'react';

const Intro = (props) => {
    return (
        <div className='object-fill max-w-[1240px] mx-auto px-4 items-center text-white whitespace-nowrap h-fit' style={{
            backgroundImage: `url(${props.img})`, height:'400px', backgroundPosition: "center"}}>
            <h4 className='invisible'>_</h4>
            <h2 className='mt-32 text-2xl text-center'>{props.title}</h2>
            <h3 className='mt-8 text-lg text-center'>{props.text1}<br />{props.text2}</h3>
        </div>
    );
};

export default Intro;