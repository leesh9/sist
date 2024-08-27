'use client'
import { Inter } from "next/font/google";
import "./globals.css";
import Link from "next/link";
import Header from "@/component/Header";
import { SessionProvider } from "next-auth/react";

const inter = Inter({ subsets: ["latin"] }); 

export default function RootLayout({ children }) {  
  return (
    <html lang="en">
      
      <body className={inter.className}>
      <SessionProvider>
        <Header />
        {children}
      </SessionProvider>
      </body>
    </html>
  );
}
