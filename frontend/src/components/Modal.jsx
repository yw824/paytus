import React from 'react';
import '../assets/Modal.css';
const Modal = (notice, func) => {
    return (
        <div className='modal' onClick={func}>
            <div className='overlay'></div>
            <div className='modal-content'>
                <h2>{notice.noticetitle}</h2>
                <p>{notice.noticetext}</p>
                <button className='close-modal' onClick={func}>CLOSE</button>
            </div>
        </div>
    )
};

export default Modal;