// 
//app/api/auth/[...nextauth]/route.ts

import NextAuth from "next-auth/next";
import CredentialsProvider from "next-auth/providers/credentials";
import KakaoProvider from "next-auth/providers/kakao";

export default NextAuth({
  providers: [
    KakaoProvider({
      clientId: process.env.KAKAO_CLIENT_ID,
      clientSecret: process.env.KAKAO_CLIENT_SECRET,//통신 
    }),
  ],
  callbacks: { //session에 토큰 저장
    async jwt({ token, user }) {
      return { ...token, ...user };
    },

    async session({ session, token }) {
      session.user = token;
      console.log("토큰:"+JSON.stringify(session));
      return session;
    },
  },

  // 이 부분은 잠시만 주석처리 하겠습니다.
  // 강의 마지막 부분에 다시 논의하겠습니다.
  // pages: {
  //   signIn: "/signin",
  // },
});
