import React from 'react';

const News = () => {
    return (
        <div className='bg-white bg-local justify-between max-w-[1240px] mx-auto text-black'>
            <h1 className='mx-auto mt-6 text-center text-4xl font-bold'>보도자료</h1>
            <div>
                <ul className='mt-4'>
                    <li className='p-6 text-xl text-bold border-b border-gray-600'>
                        <p className='text-medium'><span className='text-[#F1511F] font-bold'>매일경제</span> <span className='text-[#D9D9D9]'>2023.04</span></p>
                        <a href='https://n.news.naver.com/mnews/article/009/0005111582?sid=101' target="_blank">
                            페이투스, 지난해 매출 전년 대비 219%↑…영업이익은 134% 증가
                        </a>
                    </li>
                    <li className='p-6 text-xl text-bold border-b border-gray-600'>
                        <p className='text-medium'><span className='text-[#F1511F] font-bold'>뉴스1</span> <span className='text-[#D9D9D9]'>2022.01</span></p>
                        <a href='https://www.news1.kr/articles/?4561059' target="_blank">
                            결제사업자 페이투스, 작년 누적 가맹점 4000곳 돌파…"올해 1만곳 목표"
                        </a>
                    </li>
                    <li className='p-6 text-xl text-bold border-b border-gray-600'>
                        <p className='text-medium'><span className='text-[#F1511F] font-bold'>이데일리</span> <span className='text-[#D9D9D9]'>2022.01</span></p>
                        <a href='https://www.edaily.co.kr/news/read?newsId=01430086632196736&mediaCodeNo=257&OutLnkChk=Y' target="_blank">
                            페이투스, 전자결재플랫폼 신규 시스템 오픈
                        </a>
                    </li>
                    <li className='p-6 text-xl text-bold border-b border-gray-600'>
                        <p className='text-medium'><span className='text-[#F1511F] font-bold'>전자신문</span> <span className='text-[#D9D9D9]'>2021.05</span></p>
                        <a href='https://m.etnews.com/20210520000260?obj=Tzo4OiJzdGRDbGFzcyI6Mjp7czo3OiJyZWZlcmVyIjtOO3M6NzoiZm9yd2FyZCI7czoxMzoid2ViIHRvIG1vYmlsZSI7fQ%3D%3D' target="_blank">
                            ㈜페이투스, 차지인과 전기차 충전 플랫폼 전략적 제휴 체결
                        </a>
                    </li>
                    <li className='p-6 text-xl text-bold border-b border-gray-600'>
                        <p className='text-medium'><span className='text-[#F1511F] font-bold'>전자신문</span> <span className='text-[#D9D9D9]'>2021.04</span></p>
                        <a href='https://m.etnews.com/20210428000235' target="_blank">
                            페이투스, 한고집 프랜차이즈 '단군페이' 무인키오스크 공급계약
                        </a>
                    </li>
                    <li className='p-6 text-xl text-bold border-b border-gray-600'>
                        <p className='text-medium'><span className='text-[#F1511F] font-bold'>매일경제</span> <span className='text-[#D9D9D9]'>2021.04</span></p>
                        <a href='https://www.mk.co.kr/news/business/9839321' target="_blank">
                            페이투스와 지원코리아 공공배달플랫폼 시장 진출 선언
                        </a>
                    </li>
                </ul>
            </div>

        </div>
    )
};

export default News;