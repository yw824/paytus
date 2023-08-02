import React, {useEffect, useState} from 'react';
import axios from 'axios';

import Navbar from '../components/Navbar';
import Footer from '../components/Footer';

const Payments = () => {
    const [pays, setPays] = useState('')
    useEffect(() => {
        axios.get('/api/payments')
        .then(response => setPays(response.data))
        .catch(error => console.log(error))
    }, []);

    return (
        <div>
            <Navbar />
            <div className='flex  items-center h-24 max-w-[1240px] mx-auto text-white'>
                <h1 className='w-full text-3xl font-bold text-[#F15D3C] m-4'>Payment Page</h1>
                <br /><hr /> <br />
                <h2 className='w-full text-xl font-bold text-black m-4'>from backend : {pays}</h2>
            </div>
            <Footer />
        </div>
    );
};

export default Payments;
// 