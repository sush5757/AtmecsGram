export interface CustomBottonProps {
  btnText: string;
  isOutline: boolean;
  textSize: string;
  bgColor: string;
  radius: string;
}
export interface Post {
  id: string;
  user: User;
  description: string;
  image: string;
  likesCount: number;
  commentsCount: number;
  sharesCount: number;
}
export interface UserResponse {
  data: User[];
}
export interface User {
  avatar?: string;
  email: string;
  first_name?: string;
  id?: number;
  last_name?: string;
  password: string;
  posts?: number;
  following?: number;
  followers?: number;
  bio?: string;
}
