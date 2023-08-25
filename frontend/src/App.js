import React from 'react';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Main from './pages/Main';
import Payments from './pages/Payments';
import Notice from './pages/Notice';
import FAQ from './pages/FAQ';
import Admin_Files from './pages/Admin_Files';

function App() {
  return (
    <Router>
        <Routes>
          <Route path="/" element={<Main />} />
          <Route path="/payments" element={<Payments />} />
          <Route path="/faq" element={<FAQ />} />
          <Route path="/notice" element={<Notice />} />
            <Route path="/admin_files" element={<Admin_Files />} />
      </Routes>
    </Router>
  )
}

export default App;
