import React from 'react';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Main from './pages/Main';
import Payments from './pages/Payments';
import Notice from './pages/Notice';
import FAQ from './pages/FAQ';
import Admin_Files from './pages/Admin_Files';
import Admin_Notices from './pages/Admin_Notices';
import Files from './pages/Files';

function App() {
  return (
    <Router>
        <Routes>
          <Route path="/" element={<Main />} />
          <Route path="/payments" element={<Payments />} />
          <Route path="/faq" element={<FAQ />} />
          <Route path="/notice" element={<Notice />} />
          <Route path="/admin_files" element={<Admin_Files />} />
          <Route path="/admin_notices" element={<Admin_Notices />} />
          <Route path="/files" element={<Files />} />
      </Routes>
    </Router>
  )
}

export default App;
