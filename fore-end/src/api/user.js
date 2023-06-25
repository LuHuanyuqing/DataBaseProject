import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/student/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: '/student/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/student/logout',
    method: 'post'
  })
}
