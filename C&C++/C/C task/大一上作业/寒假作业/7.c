#include <stdio.h>
#include <string.h>

char s3[100];

void String_ing(char *s1, char *s2)
{
	int j = 0;
	int l = 0;
	while (strstr(s1 + l, s2))
	{
		int i = l;

		l = strstr(s1 + l, s2) - s1;

		for (; i < l; ++i)
		{
			s3[j ++] = s1[i];
		}
		l += strlen(s2);
	}
	while (s1[l])
		s3[j ++] = s1[l++];
}

int main()
{
	char s1[100];
	char s2[100];

	gets(s1);
	gets(s2);
	memset(s3, 0, sizeof(s3));

	String_ing(s1,s2);
	while (strstr(s3, s2))
	{
		strcpy(s1, s3);
		memset(s3, 0, sizeof(s3));
		String_ing(s1, s2);
	}
	puts(s3);

	return 0;
}
