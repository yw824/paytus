import React from 'react';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Main from './pages/Main';
import Payments from './pages/Payments';
import FAQ from './pages/FAQ';

function App() {
  return (
    <Router>
        <Routes>
          <Route path="/" element={<Main />} />
          <Route path="/payments" element={<Payments />} />
          <Route path="/faq" element={<FAQ />} />
      </Routes>
    </Router>
  )
}

export default App;
