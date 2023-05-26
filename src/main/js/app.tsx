import React from 'react';
import { createRoot } from 'react-dom/client';
import './assets/tailwind-built.css'

function App() {
	return <div>test</div>
}
const domNode = document.getElementById('react');
const root = createRoot(domNode as HTMLElement);
root.render(<App />);